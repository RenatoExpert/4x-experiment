package com.shogunautomacao.app;

//import org.apache.plc4x.java.opcua.config.OpcuaConfiguration;

public class App {
	public static void main(String[] args) throws Exception {
		String host = "ec2-3-93-58-9.compute-1.amazonaws.com";
		System.out.println("Hello World!");
		//OpcuaConfiguration config = new OpcuaConfiguration();
		PlcConnection plcConnection = PlcDriverManager.getDefault().getConnectionManager().getConnection(connectionString);
		System.out.println("Works");

	}
}

