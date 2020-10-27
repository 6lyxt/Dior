package at.dietze.dior;

import at.dietze.dior.threads.InstallThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiorActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("start")) {
            new InstallThread().start();
        }
    }
}
