import java.io.*;

public class PipedExample {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream(pos);

        Thread writer = new Thread(() -> {
            try {
                pos.write("Hello from Thread 1".getBytes());
                pos.close();
            } catch (IOException e) { e.printStackTrace(); }
        });

        Thread reader = new Thread(() -> {
            try {
                int data;
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }
            } catch (IOException e) { e.printStackTrace(); }
        });

        writer.start();
        reader.start();
    }
}
