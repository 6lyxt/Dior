package at.dietze.dior;

import at.dietze.dior.threads.InstallThread;

import javax.swing.*;

public class Dior {

    /* Global Variables */
    public static InstallThread INSTALL_THREAD = new InstallThread();
    public static final JFrame FRAME = new JFrame("Dior - Free Open Source Minecraft Mod Installer");

    /* Main Method */
    public static void main(String[] args){
        new Dior().initFrame();
    }

    /* Mainframe construction */
    private void initFrame() {

        FRAME.setResizable(false);
        FRAME.setVisible(true);
        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
