package controllers.helpers;

import controllers.models.*;
import javax.xml.bind.*;
import java.io.*;

public class LoggerFileHandler {
    private Util util;
    private static LoggerFileHandler logFileHandler;

    private LoggerFileHandler() {
    }

    public static LoggerFileHandler getInstance() {
        if (logFileHandler == null) {
            logFileHandler = new LoggerFileHandler();
        }
        return logFileHandler;
    }

    public Util saveipAddress(String ipAddress) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Util.class);
            util = new Util();
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(util , new FileWriter("C:\\ip addresses.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return util;
    }
}
