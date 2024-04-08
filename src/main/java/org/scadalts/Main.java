package org.scadalts;

import org.scadalts.Socket;

public class Main {
	public static void main(String[] args) {
		System.out.println("Starting App");
		new Thread(Socket.connect).start();
	}
}
				

				/*


				           try (PlcConnection connection = PlcDriverManager.getDefault()
                .getConnectionManager()
                //.getConnection("opcua:tcp://127.0.0.1:50000?discovery=false");
                .getConnection("opcua:tcp://opcuaserver.com:48010?discovery=false")) {

            if (connection.isConnected()) {
                logger.info("CONNECTED");
            }

            PlcReadRequest request = connection.readRequestBuilder().build();
            CompletableFuture<? extends PlcResponse> plcResponse = request.execute();
            PlcResponse response = plcResponse.get(5000, TimeUnit.MILLISECONDS);
            logger.info("Res: " + response);
        }
				PlcReadRequest.Builder builder = connection.readRequestBuilder();
				builder.addTagAddress("value-1", "ns=2;i=5");
				PlcReadRequest request = builder.build();
				CompletableFuture<? extends PlcReadResponse> futureResponse = request.execute();
				futureResponse.handle((content, error) -> {
					if(error) {
						System.out.println("Found an error!");
						System.out.println(error);
					}
				});
				futureResponse.get();
			
				if(connection.isConnected()) {
					System.out.println("Connected with success!");
				} else {
					System.out.println("Not connected for unknown reason");
				}
				*/
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

