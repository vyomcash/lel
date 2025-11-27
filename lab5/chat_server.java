package lab5;

import java.net.*;
import java.util.Scanner;
public class chat_server {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(9876);
        Scanner sc = new Scanner(System.in);
        byte[] buffer = new byte[1024];

        System.out.println("Server running...");

        while (true) {
            // Receive message
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            server.receive(packet);
            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Client: " + msg);
            if (msg.equalsIgnoreCase("bye")) break;

            // Reply
            System.out.print("Server: ");
            String reply = sc.nextLine();
            byte[] send = reply.getBytes();
            InetAddress clientAddr = packet.getAddress();
            int clientPort = packet.getPort();
            server.send(new DatagramPacket(send, send.length, clientAddr, clientPort));
            if (reply.equalsIgnoreCase("bye")) break;
        }

        server.close();
        System.out.println("Chat ended.");
    }
}

