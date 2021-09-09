package com.csw.netfoundry;
import org.openziti.Ziti;
import org.openziti.ZitiAddress;
import org.openziti.ZitiContext;

import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

public class Main {

    public static final String ID_FILE = "/Users/victoria/Documents/csw_code/netfoundry/nf-node-sdk/signal-server.json";

    public static void connectAsClient() {
        System.out.println("INFO :: Connecting Java SDK as Client");
        Ziti.init(ID_FILE, "".toCharArray(), false);
    }

    public static void connectAsServer() {
        System.out.println("INFO :: Connecting Java SDK as Server");
        try {
            ZitiContext context = Ziti.newContext(ID_FILE, "".toCharArray());
            AsynchronousServerSocketChannel asC = context.openServer();
            asC.bind(new ZitiAddress.Bind("service_name"));
        } catch (IOException ioe) {
            System.out.println("ERROR => Caught Exception: " + ioe);
        }

    }

    public static void main(String[] args){
        String service = args[0];
        connectAsServer();
    }
}
