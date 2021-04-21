package controllers.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Cached-data")
public class CachedData {
    private int userCount;

    public CachedData() {

    }

    public CachedData(int userCount) {
        this.userCount = userCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
}