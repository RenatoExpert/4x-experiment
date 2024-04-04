package org.scadalts.opc;

public class Main {
	public static void main(String[] args) throws PlcConnectionException {
		String url = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
		PlcConnection plcConnection = PlcDriverManager.getDefault()
			.getConnectionManager()
			.getConnection(url);

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

