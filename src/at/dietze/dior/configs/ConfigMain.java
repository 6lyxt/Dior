package at.dietze.dior.configs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigMain {

    /* Method to read file data */
    public String getConfigData(){
        String data = "";
        try {
            File cfg = new File("config.yml");
            Scanner sc = new Scanner(cfg);
            while (sc.hasNextLine()){
                data = sc.nextLine();
            }
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "An error occured";
        }
    }

    /* Method to parse file data */
    public String[] parseConfigData(){
        String data = getConfigData();
        if(data.equalsIgnoreCase("An error occured")) return null;
        String url = data.substring(data.lastIndexOf("URL:"));
        String version = data.substring(data.lastIndexOf("Version:"));

        return new String[]{url,version};
    }


}
