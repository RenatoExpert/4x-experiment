package org.scadalts;

import java.util.concurrent.TimeUnit;
import org.scadalts.ReadResponse;
import org.apache.plc4x.java.api.PlcConnection;
import org.apache.plc4x.java.api.PlcDriverManager;
import org.apache.plc4x.java.api.messages.PlcReadResponse;
import org.apache.plc4x.java.api.messages.PlcReadRequest;

public class Connection implements AutoCloseable {
	String url;
	PlcConnection connection;
	public Connection (String FullURL) throws Exception {
		url = FullURL;
		connection = PlcDriverManager.getDefault()
			.getConnectionManager()
			.getConnection(url);
		if (connection.isConnected()) {
			System.out.println("Connected with success!");
		} else {
			System.out.println("Connection not estabilished!");
		}
	}
	public ReadResponse read(String[][] tagList) throws Exception {
		PlcReadRequest.Builder builder = connection.readRequestBuilder();
		for (String[] tag: tagList) {
			builder.addTagAddress(tag[0], tag[1]);
		}
		PlcReadResponse response = builder.build()
			.execute()
			.get(5000, TimeUnit.MILLISECONDS);
		return new ReadResponse(response);
	}
	public void close() throws Exception {
		connection.close();
	}
}

