//Gopal Reekoye
//30/03/2021
//
//CSC3002F-A1
//
//Server.java
//



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class Server
{
	public static void main(String[] args) throws SocketException, IOException
	{
		DatagramSocket serverSocket = new DatagramSocket(9876);
		boolean bye = false;

		while(true)
		{
			byte[] receivebuffer = new byte[1024];
			byte[] sendbuffer = new byte[1024];
			DatagramPacket receivedPacket= new DatagramPacket(receivebuffer, receivebuffer.length);
			serverSocket.receive(receivedPacket);
			InetAddress IP = receivedPacket.getAddress();
			int portNumber = receivedPacket.getPort();
			String clientData = new String(receivedPacket.getData());
			System.out.println("\nClient: "+clientData);
			System.out.print("\nServer");
			BufferedReader serverRead = new BufferedReader(new InputStreamReader(System.in));
			String serverData = serverRead.readLine();

			sendbuffer=serverData.getBytes();
			DatagramPacket sendPacket= new DatagramPacket(sendbuffer, sendbuffer.length, IP, portNumber);
			serverSocket.send(sendPacket);
			
			if(serverData.equalsIgnoreCase("bye"))
			{
				System.out.println("Connection ended by server");
				break;
			}


		}
		serverSocket.close();
	}
}
