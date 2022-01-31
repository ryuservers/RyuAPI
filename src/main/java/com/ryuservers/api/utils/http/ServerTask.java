package com.ryuservers.api.utils.http;

import org.eclipse.jetty.server.Server;

public class ServerTask implements Runnable{
    @Override
    public void run() {
        try {
            Server server = new Server(8080);
            server.start();
            server.join();
        } catch (Exception ex) {
        }
    }
    
}
