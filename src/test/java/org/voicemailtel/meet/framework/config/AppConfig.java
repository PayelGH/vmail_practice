
package org.voicemailtel.meet.framework.config;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
public class AppConfig {
    private static AppConfig instance;
    private Properties properties;// Properties is a java inbuilt class, which is used to access the values of properties from.properties file

    private AppConfig(){ //constructor is to be written after declaration of variables and before any method
        Path path = Paths.get("src/test/resources/framework.properties");//here the path to locate the framework.prperties is given
        try {
            FileInputStream stream = new FileInputStream(path.toFile());//path.toFile() converts to an object of File class or File type. FileInputStream class is used to read a file from disk
            properties = new Properties();//make an object of Properties class and store it in "properties" variable
            properties.load(stream);//here the load() method of Properties clas is used to load the framework.properties file.WE need to load the file in order to access its contents
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String  getProperties(String key) {
        if( instance == null)//when getProperties() method called for the first time, "instance" variable which was null until then will be initialized with an instance of AppConfig object
        {
            instance = new AppConfig();
        }
        return instance.properties.getProperty(key);// getProperty
    }
}


