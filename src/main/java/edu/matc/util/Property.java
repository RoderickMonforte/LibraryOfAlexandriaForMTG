package edu.matc.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;


/**
 * Created by student on 4/19/17.
 */
public class Property {
    private static Properties properties = null;
    private final Logger log = Logger.getLogger(this.getClass());

    public static String get(String field) {

        return properties.getProperty(field);
    }

    public static boolean isNull() {
        return (properties == null);
    }

    /**
     *  This reads the properties
     */
    public Property() {

        properties = new Properties();
        String aString = "/LibraryOfAlexandria.properties";

        //try reading properties file
        try {

            properties.load(this.getClass().getResourceAsStream(aString));

        } catch (NullPointerException nullPointerException) {

            log.error("Properties File Is Empty");
            log.error(nullPointerException.getMessage());

        } catch (IOException ioException) {

            log.error("Error Reading File");
            log.error(ioException.getMessage());

        } catch (Exception exception) {

            log.error("General Error");
            log.error(exception.getMessage());

        }

    }

}
