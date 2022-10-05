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
package org.projecthusky.xua.communication.xua.impl.ch.integration;

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
