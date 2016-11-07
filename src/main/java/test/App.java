package test;

import dao.implementation.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;


public class App {
    public static void main(String[] args) {


        Properties prop = new Properties();

        try {
            //load a properties file from class path, inside static method
            prop.load(App.class.getClassLoader().getResourceAsStream("project.properties"));

            //get the property value and print it out
            System.out.println(prop.getProperty("branch.name"));
            System.out.println(prop.getProperty("commit.hash"));
            System.out.println(prop.getProperty("application.version"));

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
