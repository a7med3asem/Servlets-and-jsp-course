package controllers.listeners;

import jakarta.servlet.*;

public class RequestsListener implements ServletRequestListener {
    private int requestsCount;
    public void requestInitialized(ServletRequestEvent event) {
        requestsCount++;
        System.out.println("Requests now are " + requestsCount);
    }

    public void requestDestroyed(ServletRequestEvent event) {
        requestsCount--;
        System.out.println("Requests now are " + requestsCount);
    }
}
