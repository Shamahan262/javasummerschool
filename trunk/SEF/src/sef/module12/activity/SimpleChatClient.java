/**
 * 
 */
package sef.module12.activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 * @author Bernards Gulbis
 * 
 */
public class SimpleChatClient implements Runnable {

	private Socket client;
	private PrintWriter out;
	private BufferedReader in;
	private List<SimpleChatClient> clientList;

	/**
	 * @param args
	 */
	public SimpleChatClient(Socket client, List<SimpleChatClient> clientList) {
		this.client = client;
		this.clientList = clientList;
		try {
			this.out = new PrintWriter(this.client.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(
					this.client.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public synchronized void run() {
		try {
			this.out.println("You have reached simple chat server "
					+ this.client.getInetAddress());
			this.out.println("- enter a string or type 'END' to exit");

			while (!this.client.isClosed()) {

				// receiving message
				String line = in.readLine();

				if (line == null || line.toUpperCase().trim().equals("END")) {
					// disconnect
					this.client.close();

				} else {
					// sending message to all clients
					for (SimpleChatClient c : clientList) {
						if (!this.equals(c)) {
							c.out.println(this.client.getInetAddress()
									.getHostName() + ": " + line);
						}
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (this.clientList != null) {
				this.clientList.remove(this);
			}
			try {
				if (this.out != null) {
					this.out.close();
				}
				if (this.in != null) {
					this.in.close();
				}
				if (this.client != null) {
					this.client.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}