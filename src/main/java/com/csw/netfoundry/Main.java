package com.csw.netfoundry;
import org.openziti.Ziti;
import org.openziti.ZitiAddress;
import org.openziti.ZitiContext;

import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

//Alyssa-Test
//Alyssa-Test2
public class Main {

    public static final String ID_FILE = "/Users/victoria/Documents/csw_code/netfoundry/identity_files/java-service-identity.json";
    // Insert fake AWS credentials here to test git-secrets scanning
    public static String aws_access_key_id = "FAKERKQUU5C2WX5FFAKE";
    public static String aws_secret_access_key = "faketl1rIDgjnMP68Ljyawnpjgbq1vh8sNM1fake";

    public static void connectAsClient() {
        System.out.println("INFO :: Connecting Java SDK as Client");
        Ziti.init(ID_FILE, "".toCharArray(), false);
    }

    public static void connectAsServer(String serviceName) {
        System.out.println("INFO :: Connecting Java SDK as Server");
        while (true) {
            try {
                ZitiContext zContext = Ziti.newContext(ID_FILE, "".toCharArray());
                AsynchronousServerSocketChannel asC = zContext.openServer();
                asC.bind(new ZitiAddress.Bind(serviceName));
            } catch (IOException ioe) {
                System.out.println("ERROR => Caught Exception: " + ioe);
            }
        }
    }

    public static void main(String[] args){
//        String service = args[0];
        String serviceName = "simple";
        connectAsServer(serviceName);
    }
}
