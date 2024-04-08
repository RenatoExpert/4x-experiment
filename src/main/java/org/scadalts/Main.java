package org.scadalts;

import org.scadalts.Socket;

public class Main {
	public static void main(String[] args) {
		System.out.println("Starting App");
		new Thread(Socket.connect).start();
	}
}

