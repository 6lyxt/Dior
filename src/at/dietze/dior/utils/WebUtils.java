package at.dietze.dior.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class WebUtils {
    public static String getUrlSourceCode(String urlPath) {
        try {
            Reader input = new InputStreamReader((new URL(urlPath)).openStream());
            BufferedReader reader = new BufferedReader(input);
            StringBuilder code = new StringBuilder();
            String s = "";
            while ((s = reader.readLine()) != null)
                code.append(s);
            input.close();
            reader.close();
            return code.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getInfo(String code, String name) {
        return code.split(name + ":")[1].split("<")[0];
    }
}

