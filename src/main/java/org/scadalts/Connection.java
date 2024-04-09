package org.scadalts;

import org.scadalts.ReadResponse;

import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.PlcConnectionManager;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcResponse;
import org.apache.plc4x.java.api.PlcDriver;
import org.apache.plc4x.java.api.PlcDriverManager;
import org.apache.plc4x.java.DefaultPlcDriverManager;
import org.apache.plc4x.java.api.exceptions.PlcConnectionException;
import org.apache.plc4x.java.api.messages.PlcReadRequest;
import org.apache.plc4x.java.api.messages.PlcBrowseRequest;
import org.apache.plc4x.java.api.messages.PlcBrowseResponse;
import org.apache.plc4x.java.api.metadata.PlcDriverMetadata;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class Connection implements AutoCloseable {
	String url;
	PlcConnection connection;
	public Connection (String FullURL) {
		url = FullURL;
		PlcConnectionManager connectionManager = PlcDriverManager.getDefault().getConnectionManager();
		connection = connectionManager.getConnection(url);
		if (connection.isConnected()) {
			System.out.println("Connected with success!");
		} else {
			System.out.println("Connection not estabilished!");
		}
	}
	public ReadResponse read(String[][] tagList) {
		PlcReadRequest.Builder builder = connection.readRequestBuilder();
		for (String[] tag: tagList) {
			builder.addTagAddress(tag[0], tag[1]);
		}
		PlcReadRequest request = builder.build();
		CompletableFuture<? extends PlcReadResponse> responseFuture = request.execute();
		ReadResponse response = responseFuture.get(5000, TimeUnit.MILLISECONDS);
		return response;
	}
	public void close() {
		connection.close();
	}
}

