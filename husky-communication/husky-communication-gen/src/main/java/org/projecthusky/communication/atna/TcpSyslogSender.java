/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.atna;

import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.audit.AuditException;
import org.openehealth.ipf.commons.audit.AuditMetadataProvider;
import org.openehealth.ipf.commons.audit.protocol.AuditTransmissionProtocol;
import org.openehealth.ipf.commons.audit.protocol.RFC5425Protocol;
import org.openehealth.ipf.commons.audit.protocol.TLSSyslogSenderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.SocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serial;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * An implementation of a TCP syslog sender, compliant with the RFC 5425 syslog frame format.
 *
 * @author Quentin Ligier
 * @implNote This class is a copy of the class {@link TLSSyslogSenderImpl}, only overriding the constructors to use
 * {@link javax.net.SocketFactory} instead of {@link javax.net.ssl.SSLSocketFactory}.
 *
 * @author Lawrence Tarbox, Derived from code written by Matthew Davis of IBM.
 * @author Christian Ohr
 * @author Quentin Ligier
 **/
public class TcpSyslogSender extends RFC5425Protocol implements AuditTransmissionProtocol {

    private static final Logger LOG = LoggerFactory.getLogger(TcpSyslogSender.class);
    private static final int MIN_SO_TIMEOUT = 1;
    private static final Boolean DEFAULT_SOCKET_KEEPALIVE = Boolean.TRUE;

    private final AtomicReference<Socket> socket = new AtomicReference<>();
    private final SocketFactory socketFactory;
    private final TLSSyslogSenderImpl.SocketTestPolicy socketTestPolicy;

    /**
     * Default constructor.
     */
    public TcpSyslogSender() {
        this(TLSSyslogSenderImpl.SocketTestPolicy.TEST_BEFORE_WRITE);
    }

    /**
     * Constructor with default socket factory.
     *
     * @param socketTestPolicy Determining if and when to test the socket for a connection close/reset
     */
    public TcpSyslogSender(final TLSSyslogSenderImpl.SocketTestPolicy socketTestPolicy) {
        this(SocketFactory.getDefault(), socketTestPolicy);
    }

    /**
     * Constructor with default socket test policy.
     *
     * @param socketFactory Socket factory to be used for creating the TCP socket.
     */
    public TcpSyslogSender(final SocketFactory socketFactory) {
        this(socketFactory, TLSSyslogSenderImpl.SocketTestPolicy.TEST_BEFORE_WRITE);
    }

    /**
     * Full constructor.
     *
     * @param socketFactory    Socket factory to be used for creating the TCP socket.
     * @param socketTestPolicy Determining if and when to test the socket for a connection close/reset
     */
    public TcpSyslogSender(final SocketFactory socketFactory,
                           final TLSSyslogSenderImpl.SocketTestPolicy socketTestPolicy) {
        super();
        this.socketFactory = Objects.requireNonNull(socketFactory);
        this.socketTestPolicy = Objects.requireNonNull(socketTestPolicy);
    }

    @Override
    public String getTransportName() {
        return "TCP";
    }

    private Socket getSocket(AuditContext auditContext) {
        if (socket.get() == null)
            socket.compareAndSet(null, createSocket(auditContext));
        return socket.get();
    }

    @Override
    public void send(AuditContext auditContext, AuditMetadataProvider auditMetadataProvider, String auditMessage) throws Exception {
        if (auditMessage != null) {
            var msgBytes = getTransportPayload(auditMetadataProvider, auditMessage);
            LOG.debug("Auditing {} bytes to {}:{}",
                      msgBytes.length,
                      auditContext.getAuditRepositoryHostName(),
                      auditContext.getAuditRepositoryPort());
            try {
                doSend(auditContext, msgBytes);
                if (LOG.isTraceEnabled()) {
                    LOG.trace(new String(msgBytes, StandardCharsets.UTF_8));
                }
            } catch (SocketException | SocketTimeoutException e) {
                try {
                    LOG.info("Failed to use existing socket. Will create a new connection and retry.");
                    closeSocket(socket.get());
                    socket.set(null);
                    doSend(auditContext, msgBytes);
                } catch (Exception exception) {
                    LOG.error("Failed to audit using new socket, giving up - this audit message will be lost.");
                    closeSocket(socket.get());
                    socket.set(null);
                    // re-throw the exception so caller knows what happened
                    throw exception;
                }
            }
        }
    }

    @Override
    public void shutdown() {
        if (socket.get() != null) {
            // TODO could wait until everything is sent
            closeSocket(socket.get());
        }
    }

    private synchronized void doSend(AuditContext auditContext, byte[] msgBytes)
            throws IOException {
        final var socket = getSocket(auditContext);

        if (socketTestPolicy.isBeforeWrite()) {
            LOG.trace("Testing whether socket connection is alive and well before attempting to write");
            if (!isSocketConnectionAlive(socket)) {
                closeSocket(socket);
                throw new FastSocketException(
                        "Read-test before write operation determined that the socket connection is dead");
            }
            LOG.debug("Socket connection is confirmed to be alive.");
        }

        LOG.trace("Now writing out ATNA record");
        var out = socket.getOutputStream();
        out.write(msgBytes);
        out.flush();
        LOG.trace("ATNA record has been written ({} bytes)", msgBytes.length);

        if (socketTestPolicy.isAfterWrite()) {
            LOG.trace(
                    "Testing whether socket connection is alive and well after write to confirm the write operation");
            if (!isSocketConnectionAlive(socket)) {
                closeSocket(socket);
                throw new FastSocketException(
                        "Read-test after write operation determined that the socket connection is dead");
            }
            LOG.debug("Socket connection is confirmed alive. Assuming write operation has succeeded");
        }
    }

    private Socket createSocket(AuditContext auditContext) {
        final Socket socket;
        var auditRepositoryAddress = auditContext.getAuditRepositoryAddress();
        try {
            socket = socketFactory.createSocket(
                    auditRepositoryAddress,
                    auditContext.getAuditRepositoryPort());
            setSocketOptions(socket);
            if (socketTestPolicy != TLSSyslogSenderImpl.SocketTestPolicy.DONT_TEST_POLICY) {
                socket.setSoTimeout(MIN_SO_TIMEOUT);
            }
        } catch (IOException e) {
            throw new AuditException(String.format("Could not establish connection to %s:%d (%s)",
                                                   auditContext.getAuditRepositoryHostName(),
                                                   auditContext.getAuditRepositoryPort(),
                                                   auditRepositoryAddress.getHostAddress()),
                                     e);
        }
        return socket;
    }

    /**
     * Override this method to set any socket option. The default implementation
     * sets {@code SO_KEEPALIVE} to {@code true}. The method is called once for
     * every new socket instance that is created before the first ATNA record is
     * sent over that socket connection.
     * <p>
     * BEWARE: If your implementation specify any socket test policy other than
     * {@link TLSSyslogSenderImpl.SocketTestPolicy#DONT_TEST_POLICY}, then {@code SO_TIMEOUT} will be
     * set to 1 ms regardless of the value your implementation might set.
     *
     * @param socket Socket to configure
     * @throws SocketException if setting keep alive failed
     */
    protected void setSocketOptions(final Socket socket) throws SocketException {
        Objects.requireNonNull(socket);
        socket.setKeepAlive(DEFAULT_SOCKET_KEEPALIVE);
    }

    /**
     * Tries to determine whether the socket connection is alive and well by reading
     * from the socket's {@link InputStream input stream}. Since syslog is a simplex
     * protocol the results of the read can either be
     * <dl>
     * <dt>SocketTimeoutException</dt>
     * <dd>We assume the connection is alive</dd>
     * <dt>Read {@code -1}</dt>
     * <dd>Server closed connection</dd>
     * <dt>IOException</dt>
     * <dd>We assume the connection is dead</dd>
     * </dl>
     *
     * @param socket The socket (connection) under test
     * @return {@code true} if the connection is alive, {@code false} otherwise
     */
    private boolean isSocketConnectionAlive(final Socket socket) {
        boolean isAlive;
        try {
            if (socket.getSoTimeout() > 0) {
                final var nextByte = socket.getInputStream().read();
                if (nextByte > -1) {
                    LOG.warn(
                            "Socket test was able to read a byte from the socket other than the 'stream closed' value of -1. "
                                    + "This should never happen since SYSLOG is a simplex (write only) protocol! Byte value read from stream: {}",
                            nextByte);
                    isAlive = true;
                } else {
                    LOG.debug("Socket test read '-1' -> connection closed by server.");
                    isAlive = false;
                }
            } else {
                throw new IllegalStateException("Test requires an SO_TIMEOUT greater than zero set on the socket.");
            }
        } catch (SocketTimeoutException e) {
            LOG.debug("Socket read timed out; assuming the connection is still alive.");
            isAlive = true;
        } catch (IOException e) {
            LOG.warn("Socket read failed for non-timeout reason; assuming the connection is dead.");
            isAlive = false;
        }

        return isAlive;
    }

    /**
     * Closes socket if it is not null and has not been closed yet.
     *
     * @param socket Socket to close.
     */
    private void closeSocket(final Socket socket) {
        if (socket != null && !socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                LOG.debug(
                        "Failed to close pre-existing socket. As we are either shutting down or are in the process of replacing the socket this is not really a worry... Message: {}",
                        e.getMessage());
            }
        }
    }

    /**
     * We use exceptions for control flow. Which is an anti pattern. In places where
     * we raise the exception we can at least make sure the overhead of creating the
     * exception is minimal by not populating the stacktrace.
     *
     * @author taastrad
     */
    private static class FastSocketException extends SocketException {
        @Serial
        private static final long serialVersionUID = 3441388621894032996L;

        public FastSocketException(final String msg) {
            super(msg);
        }

        @Override
        public Throwable fillInStackTrace() {
            // Intentional NOOP
            return null;
        }
    }
}
