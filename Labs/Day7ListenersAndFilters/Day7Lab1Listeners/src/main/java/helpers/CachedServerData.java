package helpers;

import com.utils.CachedData;
import javax.xml.bind.*;
import java.io.*;

public class CachedServerData {
    private CachedData cachedData;
    private static CachedServerData credentialsDataInstance;

    private CachedCredentialsData() {
    }

    public static CachedServerData getInstance() {
        if (credentialsDataInstance == null) {
            credentialsDataInstance = new CachedServerData();
        }
        return credentialsDataInstance;
    }

    public CachedData saveusersCount(int usersCount) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CachedData.class);
            cachedData = new CachedData(usersCount);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(cachedData, new FileWriter("credentials.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return cachedData;
    }

    // public static void createFile(String userName, String email, String password)
    // {
    // try {
    // if(!new File("Credentials.txt").exists())
    // {
    // File file = new File("Credentials.txt");
    // file.createNewFile();
    // }

    // FileWriter writer1 = new FileWriter("Credentials.txt");
    // BufferedWriter writer = new BufferedWriter(writer1);
    // writer.write(userName);
    // writer.newLine();
    // writer.write(email);
    // writer.newLine();
    // writer.write(password);
    // writer.close();
    // } catch (IOException e) {
    // System.out.println(e.getMessage());
    // e.printStackTrace();
    // }
    // }
}
