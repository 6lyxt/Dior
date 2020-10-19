package at.dietze.dior;

import at.dietze.dior.threads.InstallThread;

import javax.swing.*;

public class Dior {

    //todo

    public static InstallThread INSTALL_THREAD = new InstallThread();
    public static final JFrame FRAME = new JFrame("Dior - Free Open Source Minecraft Mod Installer");

    public static void main(String[] args){
        new Dior().initFrame();
    }

    private void initFrame() {
        FRAME.setResizable(false);
        FRAME.setVisible(true);
        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
