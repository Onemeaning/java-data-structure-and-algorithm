package nio.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private void initServer(int port) throws IOException {


        serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.socket().bind(new InetSocketAddress("localhost",port));

        this.selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }


    private void listen() throws IOException {

        System.out.println("server started succeed");

        while (true){

            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){

                SelectionKey key = iterator.next();
                if (key.isAcceptable()){

                    SocketChannel channel = serverSocketChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector,SelectionKey.OP_READ);

                }
                else if (key.isReadable()){

                    revAndReply(key);
                }

                iterator.remove();

            }

        }


    }

    private void revAndReply(SelectionKey key) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        int i = channel.read(byteBuffer);
        if (i!=-1){
            String msg = new String(byteBuffer.array()).trim();
            System.out.println("NIOServer received message =   " + msg);
            System.out.println("NIO server reply " + msg);
            channel.write(ByteBuffer.wrap(msg.getBytes()));

        }

        else
        {
            channel.close();
        }

    }

    public static void main(String[] args) throws IOException {

        NIOServer nioServer = new NIOServer();
        nioServer.initServer(8080);
        nioServer.listen();
    }

}
