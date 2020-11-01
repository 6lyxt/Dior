package at.dietze.dior;

import at.dietze.dior.threads.InstallThread;

import javax.swing.*;
import java.awt.*;

public class Dior {

    /* Global Variables */
    public static InstallThread INSTALL_THREAD = new InstallThread();
    public static final JFrame FRAME = new JFrame("Dior - Free Open Source Minecraft Mod Installer");

    /* Main Method */
    public static void main(String[] args){
        Dior dior = new Dior();
        dior.initFrame();
    }

    /* Mainframe construction */
    private void initFrame() {
        JPanel p = new JPanel();
        JLabel title = new JLabel("Dior - Free Open Source Minecraft Mod Installer");
        JLabel desc = new JLabel("Make sure the config and the jar is in the same folder!");
        JButton install = new JButton("Install");
        FRAME.setContentPane(p);

        Font font = new Font("Verdana", Font.PLAIN,18);
        Font titleFont = new Font("Verdana", Font.PLAIN, 23);

        title.setFont(titleFont);
        desc.setFont(font);
        install.setFont(font);

        p.setLayout(null);
        FRAME.setLocationRelativeTo(null);
        FRAME.pack();

        FRAME.getContentPane().setBackground(new Color(162, 171, 255));
        FRAME.getContentPane().add(title);
        FRAME.getContentPane().add(desc);
        FRAME.getContentPane().add(install);

        install.addActionListener(new DiorActionListener());
        install.setBackground(Color.white);
        install.setActionCommand("start");

        p.add(title);
        p.add(install);
        p.add(desc);

        desc.setBounds(70,100,150,25);
        title.setBounds(15,68,200,27);
        install.setBounds(230,150,150,25);

        install.setPreferredSize(new Dimension(150,25));

        desc.setSize(desc.getPreferredSize());
        title.setSize(title.getPreferredSize());

        FRAME.setResizable(false);
        FRAME.setSize(600,600);
        FRAME.setVisible(true);
        FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
