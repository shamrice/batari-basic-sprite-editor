package io.github.shamrice.spritecreator2600.generator;

import javax.swing.*;

class SpriteCodeGenerator implements CodeGenerator {

    private JTable editorTable;
    private String inputString;

    @Override
    public String generateFromTable() {

        String outputString = "";

        for (int y = editorTable.getRowCount() - 1; y >= 0; y--) {
            outputString += "%";
            for (int x = 0; x < editorTable.getColumnCount(); x++) {
                String val = (String) editorTable.getValueAt(y, x);
                if (val == null || !val.equals("X")) {
                    outputString += "0";
                } else {
                    outputString += "1";
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

            //reverse the lines of the input data from bottom to top.
            String[] dataRows = inputString.split("\n");
            String flippedInputData = "";
            for (int i = dataRows.length - 1; i >= 0; i--) {
                flippedInputData += dataRows[i];
            }

            //set table values based on input string.
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    char data = flippedInputData.charAt((y * 8) + x);
                    if (data == '1') {
                        destinationTable.setValueAt("X", y, x);
                    } else {
                        destinationTable.setValueAt("", y, x);
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
