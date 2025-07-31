import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        String file = "students.dat";

        // Write
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(1);
            dos.writeUTF("Shivang");
            dos.writeDouble(8.5);
            System.out.println("Student data saved!");
        } catch (IOException e) { e.printStackTrace(); }

        // Read
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
        } catch (IOException e) { e.printStackTrace(); }
    }
}
