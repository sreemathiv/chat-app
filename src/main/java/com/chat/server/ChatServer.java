package com.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.chat.ui.ChatHandler;

public class ChatServer {

	private ServerSocket serverSocket;
	private final int port;
	private final ExecutorService executorService;
	private static final int DEFAULT_PORT = 2000;

	public ChatServer(int port) {
		this.port = port;
		this.executorService = Executors.newCachedThreadPool();
	}

	public void start() {
		try {
			serverSocket = new ServerSocket(port);
			System.out.printf("ChatServer listening on port %d %n", port);
			while (true) {
				Socket socket = serverSocket.accept();
				executorService.execute(new ChatHandler(socket));
			}
		} catch (IOException e) {
			System.err.println("Error Starting ChatServer. Details: " + e.getMessage());
		}
	}

	public static void main(String args[]) {
		int port = getPort(args);
		ChatServer server = new ChatServer(port);
		server.start();
	}

	private static int getPort(String[] args) {
		int port;
		if (args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				port = DEFAULT_PORT;
			}
		} else {
			port = DEFAULT_PORT;
		}
		return port;
	}

}
