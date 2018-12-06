package com.chat.client;

import java.net.Socket;

import com.chat.ui.ChatHandler;

public class ChatClient {

	private Socket socket;

	public ChatClient(String host, int port) {
		try {
			socket = new Socket(host, port);
			System.out.printf("Chat Client connected to %s %s %n",host, port);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void start() {
		new ChatHandler(socket).run();
	}
	
	public static void main(String args[]) {
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		ChatClient client = new ChatClient(host,port);
		client.start();
	}

}
