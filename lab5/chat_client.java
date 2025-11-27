package lab5;

import java.net.*;
import java.util.Scanner;

public class chat_client {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket();
        InetAddress serverAddr = InetAddress.getByName("localhost");
        Scanner sc = new Scanner(System.in);
        byte[] buffer = new byte[1024];

        while (true) {
            System.out.print("Client: ");
            String msg = sc.nextLine();
            client.send(new DatagramPacket(msg.getBytes(), msg.length(), serverAddr, 9876));
            if (msg.equalsIgnoreCase("bye")) break;

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            client.receive(packet);
            String reply = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Server: " + reply);
            if (reply.equalsIgnoreCase("bye")) break;
        }

        client.close();
        System.out.println("Chat ended.");
    }
}

