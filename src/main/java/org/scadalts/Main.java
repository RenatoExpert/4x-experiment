package org.scadalts;

import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.PlcDriver;
import org.apache.plc4x.java.api.PlcDriverManager;
import org.apache.plc4x.java.DefaultPlcDriverManager;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcBrowseRequest;
import org.apache.plc4x.java.api.messages.PlcBrowseResponse;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;


public class Main {
	public static void main(String[] args) {
		System.out.println("Starting App");
		new Thread(connect).start();
	}
	private static Runnable connect = new Runnable() {
		public void run() {
			//String url = "opcua:tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
			//String url = "opcua:tcp://opcuaserver.com:48010/?discovery=false";
			String url = "opcua:tcp://173.183.147.103:48010/?discovery=false";
			System.out.println("Starting Thread");
			try {
				PlcDriver driver = PlcDriverManager.getDefault().getDriver("opcua");
				PlcConnection connection = driver.getConnection(url);
				PlcReadRequest.Builder builder = connection.readRequestBuilder();
				if(connection.isConnected()) {
					System.out.println("Connected with success!");
				} else {
					System.out.println("Not connected for unknown reason");
				}
			} catch (Exception ex) {
				System.out.println("We got an error while connecting to plc");
				System.out.println(ex.getMessage());
			}
			//.getDriver("opcua");
        	/*

		           PlcBrowseRequest plcBrowseRequest = plcConnection.browseRequestBuilder().build();
        CompletableFuture<? extends PlcBrowseResponse> plcResponse = plcBrowseRequest.execute();

        plcResponse.thenAccept(a -> {
            logger.info("Res: " + a);
        });


			PlcBrowseRequest plcBrowseRequest = plcConnection.browseRequestBuilder().build();
			CompletableFuture<? extends PlcBrowseResponse> plcResponse = plcBrowseRequest.execute();

			plcResponse.thenAccept(a -> System.out.println("Res: " + a));

        	 */
		}
	};
}

