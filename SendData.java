import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class SendData {
    public static void main(String[] args) {
        final String HOST = args[0];
        final int PORT = Integer.parseInt(args[1]);
        String proto_data = "";

        for (int i = 2; i < args.length; i++) {
            proto_data += args[i] + " ";
        }

        final byte[] DATA = proto_data.getBytes(StandardCharsets.UTF_8);

        InetAddress ADDRESS = null;
        DatagramSocket socket = null;

        try {
            ADDRESS = InetAddress.getByName(HOST);
            socket = new DatagramSocket();
            socket.connect(ADDRESS, PORT);
            DatagramPacket packet = new DatagramPacket(DATA, DATA.length, ADDRESS, PORT);
            socket.send(packet);
        } catch (UnknownHostException e) {
            System.err.println("0x001: UnknownHostException has been occured.");
        } catch (SocketException e) {
            System.err.println("0x002: SocketException has been occured.");
        } catch (IOException e) {
            System.err.println("0x003: IOException has been occured.");
        } finally {
            socket.close();
        }
    }
}