package org.projecthusky.communication.config;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <!-- @formatter:off -->
 * <div class="en">Helping class for client testing with simulated server</div>
 * <div class="de"></div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class ServerTestHelper extends InitializerTestHelper {

  private static Logger logger = LoggerFactory.getLogger(ServerTestHelper.class);

  private static HttpServer server;

  private static int httpPort;

  private static ServerBootstrap bootstrap;

  protected static int getHttpPort() {
    return httpPort;
  }

  protected static HttpServer getServer() {
    return server;
  }

  public static HttpRequestHandler registerHandler() {
    return null;
  }

  @BeforeAll
  public static void setUpBefore() throws IOException {
    final SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(15000)
        .setTcpNoDelay(true).build();

    bootstrap = ServerBootstrap.bootstrap();
    server = bootstrap.setServerInfo("Test/1.1").setSocketConfig(socketConfig)
        .registerHandler("*", new HttpRequestHandler() {

          @Override
          public void handle(HttpRequest request, HttpResponse response,
              HttpContext context) throws HttpException, IOException {
            logger.debug("The request %s", request.getRequestLine());
            response.setStatusCode(500);
            response.setEntity(new StringEntity("Hello this is a testserver"));
          }

        }).create();

    server.start();
    httpPort = server.getLocalPort();

  }

  @AfterAll
  public static void tearDownAfter() {
    server.stop();
  }

}
