package controllers.helpers;

import controllers.models.*;
import javax.xml.bind.*;
import java.io.*;

public class CachedServerData {
    private CachedData cachedData;
    private static CachedServerData cachedServerData;

    private CachedServerData() {
    }

    public static CachedServerData getInstance() {
        if (cachedServerData == null) {
            cachedServerData = new CachedServerData();
        }
        return cachedServerData;
    }

    public CachedData saveusersCount(int usersCount) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CachedData.class);
            cachedData = new CachedData(usersCount);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(cachedData, new FileWriter("C:\\credentials.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return cachedData;
    }
}
