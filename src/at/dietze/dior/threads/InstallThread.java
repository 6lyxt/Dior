package at.dietze.dior.threads;


import at.dietze.dior.Dior;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class InstallThread extends Thread {

    private static void downloadFile(String address, String file, String filename) {
        String localFileName = file + filename;
        OutputStream out = null;
        URLConnection conn = null;
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

    public void run() {
        String path = getPath();
        String ver = getVersion();
        String mcPath = "/.minecraft/mods/" + ver + "/";
        File file = new File(path + mcPath);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            downloadFile(getDownload(), file.getAbsolutePath(), getDownloadName());
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


    private void error() {
        Dior.INSTALL_THREAD.stop();
    }

    public String getVersion(){
        return "";
    }

    public String getDownloadName(){
        return "";
    }

    public String getDownload(){
        return "";
    }
}

