package test;

import java.io.*;

public class Test {

    public static void main(String[] args) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ser.txt", true));
        OutputStream stream = new FileOutputStream(new File("ser.txt"), true)) {
            writer.append("a");
            stream.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
