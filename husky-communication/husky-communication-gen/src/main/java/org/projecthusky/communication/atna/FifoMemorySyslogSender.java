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

import com.google.common.collect.EvictingQueue;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.audit.AuditMetadataProvider;
import org.openehealth.ipf.commons.audit.protocol.AuditTransmissionProtocol;

import java.util.Collection;
import java.util.Collections;

/**
 * An implementation of a syslog sender that stores messages in a size-limited FIFO queue.
 *
 * @author Quentin Ligier
 **/
public class FifoMemorySyslogSender implements AuditTransmissionProtocol {

    private final EvictingQueue<String> queue;

    /**
     * Default constructor.
     */
    public FifoMemorySyslogSender() {
        this(100);
    }

    /**
     * Constructor with explicit buffer size.
     *
     * @param size The FIFO buffer size.
     */
    public FifoMemorySyslogSender(int size) {
        this.queue = EvictingQueue.create(size);
    }

    /**
     * Returns all audit messages in the queue.
     */
    public Collection<String> getAuditMessages() {
        return Collections.unmodifiableCollection(this.queue);
    }

    /**
     * Stores the message.
     *
     * @param auditContext          audit context that e.g. contains the destination
     * @param auditMetadataProvider dedicated (message-specific) audit metadata
     * @param auditMessage          audit message strings
     * @throws Exception thrown if sending the messages has failed
     */
    @Override
    public synchronized void send(final AuditContext auditContext,
                     final AuditMetadataProvider auditMetadataProvider,
                     final String auditMessage)
            throws Exception {
        this.queue.add(auditMessage);
    }

    /**
     * May be implemented to clean up instances on shut down
     */
    @Override
    public void shutdown() {
        this.queue.clear();
    }

    /**
     * @return name of the AuditTransmissionProtocol
     */
    @Override
    public String getTransportName() {
        return "FIFO-MEMORY";
    }
}
