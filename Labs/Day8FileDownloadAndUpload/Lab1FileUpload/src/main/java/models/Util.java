package controllers.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Util-data")
public class Util {
    private List<User> users;
    private List<String> ipAddresses;

    

    public Util() {
        users = new ArrayList<>();
        ipAddresses = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> getIPs() {
        return ipAddresses;
    }
}
