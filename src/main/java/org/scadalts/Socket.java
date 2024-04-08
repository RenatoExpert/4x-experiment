package org.scadalts;

import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcResponse;
import org.apache.plc4x.java.api.PlcDriver;
import org.apache.plc4x.java.api.PlcDriverManager;
import org.apache.plc4x.java.DefaultPlcDriverManager;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcReadResponse;
import org.apache.plc4x.java.api.messages.PlcBrowseRequest;
import org.apache.plc4x.java.api.messages.PlcBrowseResponse;
import org.apache.plc4x.java.api.metadata.PlcDriverMetadata;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class Socket {
	private Runnable connect = new Runnable() {
		public void run() {
			String url = "opcua:tcp://opcuaserver.com:48010?discovery=false";
			System.out.println("Starting Thread");
			try {
				PlcConnection connection = PlcDriverManager.getDefault().getConnectionManager().getConnection(url);
				System.out.println(connection.getMetadata().isReadSupported());

				PlcReadRequest request = connection.readRequestBuilder().build();
				CompletableFuture<? extends PlcResponse> response = request.execute();
				PlcResponse response = response.get(5000, TimeUnit.MILLISECONDS);
			} catch (Exception ex) {
				System.out.println("We got an error while connecting to plc");
				System.out.println(ex.getMessage());
				System.out.println(ex);
			}
		}
	};
}

