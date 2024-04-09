package org.scadalts;

import org.scadalts.Connection;

public class Main {
	public static void main(String[] args) {
		System.out.println("Starting App");
		String url = "opcua:tcp://server:4840?discovery=false";
		try (Connection pyserver = new Connection(url)) {
			String[][] tagList = {
				{"Input Pressure", "ns=2;i=10"},
				{"Output Pressure", "ns=2;i=11"}
			};
			pyserver.read(tagList).print();
		}
	}
}

