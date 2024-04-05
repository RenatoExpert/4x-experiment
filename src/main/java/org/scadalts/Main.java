package org.scadalts;

import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.PlcDriver;
import org.apache.plc4x.java.api.PlcDriverManager;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcBrowseRequest;
import org.apache.plc4x.java.api.messages.PlcBrowseResponse;

import java.sql.DatabaseMetaData;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) throws PlcConnectionException {
		String url = "opcua://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
		System.out.println("Hello");
		Set<String> codes = PlcDriverManager.getDefault().getProtocolCodes();
		Iterator<String> codesIterator = codes.iterator();
		codesIterator.forEachRemaining(System.out::println);
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
}

