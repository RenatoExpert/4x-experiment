package org.scadalts;

import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.PlcDriverManager;
import org.apache.plc4x.java.api.messages.PlcBrowseRequest;
import org.apache.plc4x.java.api.messages.PlcBrowseResponse;

import java.util.concurrent.CompletableFuture;

public class Main {
	public static void main(String[] args) throws Exception {
		String url = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
		PlcConnection plcConnection = PlcDriverManager.getDefault()
			.getConnectionManager()
			.getConnection(url);

		if(plcConnection.isConnected()) {
			System.out.println("CONNECTED");
		}

		PlcBrowseRequest plcBrowseRequest = plcConnection.browseRequestBuilder().build();
		CompletableFuture<? extends PlcBrowseResponse> plcResponse = plcBrowseRequest.execute();

		plcResponse.thenAccept(a -> System.out.println("Res: " + a));
	}
}

