package com.csw.netfoundry;
import org.openziti.Ziti;
import org.openziti.ZitiAddress;
import org.openziti.ZitiContext;

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
        ZitiContext context = Ziti.newContext(ID_FILE, "".toCharArray());
//        AsynchronousServerSocketChannel asC = context.openServer();
        AsynchronousSocketChannel asC = context.open();
        asC.bind(ZitiAddress.Bind());

    }

    public static void main(String[] args){
//        connectAsClient();
        connectAsServer();
    }
}
