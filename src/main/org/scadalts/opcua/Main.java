package org.scadalts.opc;

public class Main {
	public static void main(String[] args) throws PlcConnectionException {
		PlcConnection plcConnection = PlcDriverManager.getDefault()
			.getConnectionManager()
			.getConnection("opcua:tcp://127.0.0.1:50000");

		if(plcConnection.isConnected()) {
			logger.info("CONNECTED");
		}

		PlcBrowseRequest plcBrowseRequest = plcConnection.browseRequestBuilder().build();
		CompletableFuture<? extends PlcBrowseResponse> plcResponse = plcBrowseRequest.execute();

		plcResponse.thenAccept(a -> {
			logger.info("Res: " + a);
		});
	}
}
