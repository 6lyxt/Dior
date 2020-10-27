package at.dietze.dior.threads;

import at.dietze.dior.Dior;
import at.dietze.dior.configs.ConfigMain;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class InstallThread extends Thread {

    /* Whole process of downloading, saving & naming the file */
    private static void downloadFile(String address, String file, String filename) {
        String localFileName = file + filename;
        OutputStream out = null;
        URLConnection conn;
        InputStream in = null;
        try {
            URL url = new URL(address);
            out = new BufferedOutputStream(new FileOutputStream(localFileName));
            conn = url.openConnection();
            in = conn.getInputStream();
            byte[] buffer = new byte[1024];
            long numWritten = 0L;
            int numRead;
            while ((numRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numRead);
                numWritten += numRead;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* Saving files into the executers mincraft folder */
    public void run() {
        String path = getPath();
        String ver = getVersion();
        String mcPath = "/.minecraft/mods/" + ver + "/";
        File file = new File(path + mcPath);
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdir();
        }
        try {
            downloadFile(getDownload(), file.getAbsolutePath(), file.getName());
        } catch (Exception e) {
            e.printStackTrace();
            error();
        }
    }

    private String getPath() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win"))
            return System.getenv("APPDATA");
        if (os.contains("linux"))
            return System.getenv("HOME");
        error();
        return "";
    }


    /* Helpful methods */
    private void error() {
        Dior.INSTALL_THREAD.stop();
        Dior.FRAME.setName("Dior - Installation Failed!");
    }

    private String getDownload(){
        return new ConfigMain().parseConfigData()[0];
    }

    private String getVersion(){
        return new ConfigMain().parseConfigData()[1];
    }

}

