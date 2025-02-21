import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.IOException;
import java.net.DatagramPacket;

public class ReceiveData {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length -1);
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(1234);
            socket.receive(packet);
            System.out.println(new String(buffer));
        } catch (SocketException e) {
            System.err.println("0x001: SocketException has been occured.");
        } catch (IOException e) {
            System.err.println("0x002: IOException has been occured.");
        }
    }
}
