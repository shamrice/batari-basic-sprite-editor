package io.github.shamrice.spritecreator2600;

import io.github.shamrice.spritecreator2600.form.MainForm;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Batari Basic Sprite and Play Field Creator");
        frame.setContentPane(new MainForm().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
