package io.github.shamrice.spritecreator2600.form;

import javax.swing.*;

public class AboutForm {
    public JPanel getAboutPanel() {
        return aboutPanel;
    }

    private JPanel aboutPanel;
    private JTextArea aboutTextArea;

    public AboutForm() {
        String aboutText = "Batari Basic Sprite Creator is a simple tool created";
        aboutText += "\nto help assist in generating the code to set the";
        aboutText += "\nsprite data. There is a visual grid where all cells that";
        aboutText += "\nare marked black will generate to a 1 and white cells will";
        aboutText += "\ngenerate to a 0 value. The generate code button takes care of";
        aboutText += "\nflipping the sprite data so that you can easily just copy";
        aboutText += "\nand paste the text into your program.";
        aboutText += "\n\nCreated By: Erik Eriksen";
        aboutText += "\nDate: 06-2020";
        aboutText += "\nSite: http://eriks.servehttp.com\n";
        aboutTextArea.setText(aboutText);

    }
}
