/**
 * 
 */
package sef.module12.activity;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernards Gulbis
 * 
 */
public class SimpleChatServer {

	private static ServerSocket server;
	private static int port = 9999;
	private static List<SimpleChatClient> clientList;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		clientList = new ArrayList<SimpleChatClient>();
		try {
			// creating server
			server = new ServerSocket(port, 50, InetAddress.getLocalHost());
			System.out.println("ServerSocket created at "
					+ server.getInetAddress().getHostAddress());

			// Waiting for connections
			System.out.println("Waiting for connections");
			Socket client;
			while (true) {
				client = server.accept();
				System.out.println("Got a connection from: "
						+ client.getInetAddress());
				
				// Adding client
				SimpleChatClient chatClient = new SimpleChatClient(client, clientList);
				clientList.add(chatClient);

				Thread chatClientThread = new Thread(chatClient);
				chatClientThread.start();
				
				client = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null) {
					server.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
