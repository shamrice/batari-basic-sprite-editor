package io.github.shamrice.spritecreator2600.generator;

import javax.swing.*;

public interface CodeGenerator {
    String generateFromTable();
    void populate(JTable destinationTable);
    void setEditorTable(JTable editorTable);
    void setInputString(String inputString);
}
