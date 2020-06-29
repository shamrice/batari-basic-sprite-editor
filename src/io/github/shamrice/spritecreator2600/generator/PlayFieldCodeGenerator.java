package io.github.shamrice.spritecreator2600.generator;

import javax.swing.*;

class PlayFieldCodeGenerator implements CodeGenerator {

    private JTable editorTable;
    private String inputString;

    @Override
    public String generateFromTable() {

        String outputString = "";

        for (int y = 0; y < editorTable.getRowCount(); y++) {
            for (int x = 0; x < editorTable.getColumnCount(); x++) {
                String val = (String) editorTable.getValueAt(y, x);
                if (val == null || !val.equals("X")) {
                    outputString += ".";
                } else {
                    outputString += "X";
                }
            }
            outputString += "\n";
        }

        return outputString;
    }

    @Override
    public void populate(JTable destinationTable) {
        if (inputString != null && !inputString.isEmpty()) {

            inputString = inputString.replace("%", "").replace("\t", "").replace(" ", "").trim();
            inputString = inputString.replace("\n", "");

            for (int y = 0; y < 12; y++) {
                for (int x = 0; x < 32; x++) {
                    char data = inputString.charAt((y * 32) + x);
                    if (data == 'X') {
                        destinationTable.setValueAt("X", y, x);
                    } else {
                        destinationTable.setValueAt(".", y, x);
                    }
                }
            }
        }
    }

    @Override
    public void setEditorTable(JTable editorTable) {
        this.editorTable = editorTable;
    }

    @Override
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
}
