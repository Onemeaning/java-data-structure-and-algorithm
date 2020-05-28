package fundamental.nio.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {

    //
    SocketChannel socketChannel ;

    public void initClient(String host,int port) throws IOException {

        InetSocketAddress serverAddress = new InetSocketAddress(host,port);

        socketChannel = SocketChannel.open(serverAddress);

    }

    public void sendAndRecv(String words) throws IOException {

        byte[] msg = new String(words).getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(msg);
        System.out.println("Cilent sending   " + words);

        socketChannel.write(buffer);
        buffer.clear();


        socketChannel.read(buffer);
        System.out.println("Client Received:  " + new String(buffer.array()).trim());

        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {

        NIOClient client = new NIOClient();
        client.initClient("localhost",8080);
        client.sendAndRecv("i am a client");
    }


}
