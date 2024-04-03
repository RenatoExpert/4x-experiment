package com.shogunautomacao.app;

public class App {
	public static void main(String[] args) throws Exception {
		String host = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
		System.out.println("Hello World!");
		System.out.println("Works");

		//create a connection profile
		OpcUaConnectionProfile connectionProfile = new OpcUaConnectionProfile()
		.withConnectionUri(URI.create(host))
		.withClientIdUri("hurence:opc-simple:client:test")
		.withClientName("Simple OPC test client")
		.withSocketTimeout(Duration.ofSeconds(5));

		//Create an instance of a ua operations
		OpcUaOperations opcUaOperations = new OpcUaTemplate();
		//connect using our profile
		opcUaOperations.connect(connectionProfile)
		.doOnError(throwable -> logger.error("Unable to connect", throwable))
		.ignoreElement().blockingAwait();

		opcDaOperations.browseTags().foreachBlocking(System.out::println);
	}
}

