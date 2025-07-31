import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String source = "largefile.dat";
        String dest1 = "copy_unbuffered.dat";
        String dest2 = "copy_buffered.dat";

        // Unbuffered
        long start = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest1)) {
            byte[] buffer = new byte[4096];
            int bytes;
            while ((bytes = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long unbufferedTime = System.nanoTime() - start;

        // Buffered
        start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest2))) {
            byte[] buffer = new byte[4096];
            int bytes;
            while ((bytes = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long bufferedTime = System.nanoTime() - start;

        System.out.println("Unbuffered time: " + unbufferedTime / 1_000_000 + " ms");
        System.out.println("Buffered time: " + bufferedTime / 1_000_000 + " ms");
    }
}
