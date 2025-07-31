import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        String source = "input.jpg";
        String dest = "output.jpg";

        try (FileInputStream fis = new FileInputStream(source);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytes;
            while ((bytes = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytes);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(dest)) {
                while ((bytes = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytes);
                }
            }

            System.out.println("Image copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
