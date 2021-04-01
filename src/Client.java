//Reekoye Gopal
//30/03/2021
//
//CSC3002F A1
//
//Client.java

package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;



public class Client
{
	public static void main(String[] args) throws SocketException, IOException
	{
		Scanner scanning = new Scanner(System.in);
		InetAddress IP = InetAddress.getByName("localhost");
		DatagramSocket clientSocket = new DatagramSocket();
		while (true)
		{
			byte[] sendbuffer = new byte[1024];
			byte[] receivebuffer = new byte[1024];
			System.out.print("\nClient: ");
			String clientData = scanning.nextLine();
			sendbuffer = clientData.getBytes();
			DatagramPacket sendPacket= new DatagramPacket(sendbuffer, sendbuffer.length, IP, 9876);
			clientSocket.send(sendPacket);
			if(clientData.equalsIgnoreCase("bye"))
			{
				System.out.println("Connection ended by client");
				break;
			}
			DatagramPacket receivePacket = new DatagramPacket(receivebuffer, receivebuffer.length);
			clientSocket.receive(receivePacket);
			String serverData = new String(receivePacket.getData());
			System.out.print("\nServer:"+serverData);

		}
		clientSocket.close();
	}
}
