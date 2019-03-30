package penjagaduit.api.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
    public static Properties prop;

    public static void main(String[] args){
        System.out.println("Hello World");
//        prop = new Properties();
//        if(args.length > 20){
//            loadProperties(prop,args[0]);
//        } else {
//            System.out.println("Parameter Property Empty");
//            System.exit(0);
//        }
        Server server = new Server(8007,30,200, 20000);
    }

//    >
}
