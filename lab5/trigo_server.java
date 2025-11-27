package lab5;

import java.net.*;
import java.util.StringTokenizer;
public class trigo_server {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(9877);
        byte[] buffer = new byte[1024];

        System.out.println("Calculator Server running...");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            server.receive(packet);
            String input = new String(packet.getData(), 0, packet.getLength());

            StringTokenizer st = new StringTokenizer(input, " ");
            String op = st.nextToken();
            double num = Double.parseDouble(st.nextToken());

            double result = switch (op.toLowerCase()) {
                case "sin" -> Math.sin(Math.toRadians(num));
                case "cos" -> Math.cos(Math.toRadians(num));
                case "tan" -> Math.tan(Math.toRadians(num));
                default -> Double.NaN;
            };

            String output = "Result: " + result;
            server.send(new DatagramPacket(output.getBytes(), output.length(),
                    packet.getAddress(), packet.getPort()));
        }
    }
}

