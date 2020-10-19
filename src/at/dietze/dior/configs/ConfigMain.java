package at.dietze.dior.configs;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigMain {

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

    public void parseConfigData(String data){
        if(data.equalsIgnoreCase("An error occured")) return;
        //todo
    }


}
