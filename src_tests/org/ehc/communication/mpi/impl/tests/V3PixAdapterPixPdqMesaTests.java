package org.ehc.communication.mpi.impl.tests;


/**
 * See Mesa Tools TODO for installation
 * 
 * Mesa Tools require Java6 as a base, to run it locally in a docker containter make the following
 * steps
 * 
 * unzip mesatools pixpdq.zip to a directory /hostdirectory
 * 
 * docker pull dockerfile/java docker run -it -p 8100:8080 -v ~/hostdirectory:/pixdq
 * dockerfile/java:oracle-java6 in docker container cd /pipxdq chmod +x start.cmd ./start.cmd on
 * host if maxos
 * 
 * boot2docker ip The VM's Host only interface IP address is xxx.xxx.xxx.xxx
 * 
 * open browser with host address http://xxx.xxx.xxx.xxx:8100/mesa
 * 
 * Mesa validation tools
 * 
 * This tools is used to valisate pix/pdq actors againts IHE TF from october 2008. The services with
 * instructions are accessible from http://<serverAdr>:<port>/mesa/test.
 * 
 * Please use firefox. IE also works but messages are not displayed in real-time.
 * 
 * Soap messages must be sent to this endpoint (http://<serverAdr>:<port>/mesa/test).
 * 
 * @author oliveregger
 * 
 *         FIXME currently the tools returns a java exception before running a test (classpath
 *         issue?)
 * 
 */
public class V3PixAdapterPixPdqMesaTests {



}
