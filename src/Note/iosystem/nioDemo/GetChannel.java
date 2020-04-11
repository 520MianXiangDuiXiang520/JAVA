package Note.iosystem.nioDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    public static void main(String[] args) throws IOException {
        String filePath = "./src/Note/iosystem/standard.txt";
        FileChannel channel = new FileInputStream(filePath).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        while(buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
