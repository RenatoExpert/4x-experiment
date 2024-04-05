package org.scadalts;

import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.PlcDriver;
import org.apache.plc4x.java.api.PlcDriverManager;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcBrowseRequest;
import org.apache.plc4x.java.api.messages.PlcBrowseResponse;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;


public class Main {
	public static void main(String[] args) throws PlcConnectionException {
	}
	private static Runnable connect = new Runnable() {
		public void run() {
			String url = "opcua://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
			System.out.println("Hello");
			PlcDriverManager driver = PlcDriverManager.getDefault();
			//.getDriver("opcua");
        	/*
        	PlcConnection plcConnection = driver.getConnection(url);


        	if(plcConnection.isConnected()) {
				System.out.println("CONNECTED");
			}

			PlcBrowseRequest plcBrowseRequest = plcConnection.browseRequestBuilder().build();
			CompletableFuture<? extends PlcBrowseResponse> plcResponse = plcBrowseRequest.execute();

			plcResponse.thenAccept(a -> System.out.println("Res: " + a));

        	 */
		}
	};
}

