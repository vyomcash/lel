package lab5;

import java.net.*;
import java.util.Scanner;
public class trigo_client {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket();
        InetAddress serverAddr = InetAddress.getByName("localhost");
        Scanner sc = new Scanner(System.in);
        byte[] buffer = new byte[1024];

        while (true) {
            System.out.print("Operator (sin/cos/tan): ");
            String op = sc.next();
            System.out.print("Number: ");
            double num = sc.nextDouble();

            String msg = op + " " + num;
            client.send(new DatagramPacket(msg.getBytes(), msg.length(), serverAddr, 9877));

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            client.receive(packet);
            String result = new String(packet.getData(), 0, packet.getLength());
            System.out.println(result);

            System.out.print("Continue? (yes/no): ");
            if (!sc.next().equalsIgnoreCase("yes")) break;
        }

        client.close();
        System.out.println("Client exiting...");
    }
}

