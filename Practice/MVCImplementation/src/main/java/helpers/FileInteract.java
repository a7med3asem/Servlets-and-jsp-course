package helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileInteract {
    public static void createFile(String userName, String email, String password) {
        try {
            if(!new File("Credentials.txt").exists())
            {
                File file = new File("Credentials.txt");
                file.createNewFile();
            }

            FileWriter writer1 = new FileWriter("Credentials.txt");
            BufferedWriter writer = new BufferedWriter(writer1);
            writer.write(userName);
            writer.newLine();
            writer.write(email);
            writer.newLine();
            writer.write(password);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
