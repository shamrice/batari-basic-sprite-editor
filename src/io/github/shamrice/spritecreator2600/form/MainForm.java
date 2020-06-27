package io.github.shamrice.spritecreator2600.form;

import io.github.shamrice.spritecreator2600.state.ApplicationState;
import io.github.shamrice.spritecreator2600.form.item.CustomTableModelFactory;
import io.github.shamrice.spritecreator2600.generator.CodeGenerator;
import io.github.shamrice.spritecreator2600.generator.CodeGeneratorBuilder;
import io.github.shamrice.spritecreator2600.generator.GenerateType;
import io.github.shamrice.spritecreator2600.renderer.CustomJTableRenderer;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.*;

public class MainForm {

    private GenerateType generateType = GenerateType.SPRITE;


    public MainForm() {
        TableModel model = CustomTableModelFactory.getTableModel(generateType);

        spriteTable.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                System.out.println("Table drag clicked at: " + e.getX() + ", " + e.getY());
                JTable table = (JTable)e.getSource();

                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                System.out.println("Row: " + row + " :: col: " + col);

                Object currentVal = spriteTable.getValueAt(row, col);

                //TODO : this should keep track of start color and keep drawing that color until released.
                //TODO : currently just inverts whatever is in it's way.

                if (row != ApplicationState.getPrevRow() || col != ApplicationState.getPrevCol()) {

                    System.out.println("Row and col changed: row: " + row + " :: col: " + col);

                    ApplicationState.setPrevRow(row);
                    ApplicationState.setPrevCol(col);

                    if (currentVal != null && currentVal.equals("X")) {
                        spriteTable.setValueAt("", row, col);
                    } else {
                        spriteTable.setValueAt("X", row, col);
                    }
                }
            }
        });

        spriteTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Table clicked at: " + e.getX() + ", " + e.getY());
                JTable table = (JTable)e.getSource();
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                System.out.println("Row: " + row + " :: col: " + col);

                if (spriteTable.getValueAt(row, col) != null && spriteTable.getValueAt(row, col).equals("X")) {
                    spriteTable.setValueAt("", row, col);
                } else {
                    spriteTable.setValueAt("X", row, col);
                }
                //super.mouseClicked(e);
            }
        });

        CustomJTableRenderer customJTableRenderer = new CustomJTableRenderer();
        spriteTable.setDefaultRenderer(Object.class, customJTableRenderer);
        spriteTable.setModel(model);
        setEditorTableWidth();

        generateCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodeGenerator codeGenerator = new CodeGeneratorBuilder()
                        .withGenerateType(generateType)
                        .withEditorTable(spriteTable)
                        .build();
                String outputString = codeGenerator.generateFromTable();
                codeTextArea.setText(outputString);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int y = 0; y < spriteTable.getRowCount(); y++) {
                    for (int x = 0; x < spriteTable.getColumnCount(); x++) {
                        spriteTable.setValueAt("", y, x);
                    }
                }
                codeTextArea.setText("");
            }
        });

        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("About");
                frame.setContentPane(new AboutForm().getAboutPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        switchTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setSwitchTypeButtonText();

                //swap type
                generateType = (generateType == GenerateType.SPRITE) ? GenerateType.PLAY_FIELD : GenerateType.SPRITE;

                TableModel tableModel = CustomTableModelFactory.getTableModel(generateType);
                setEditorTableWidth();
                spriteTable.setModel(tableModel);

            }
        });

        loadFromDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputData = codeTextArea.getText();
                CodeGenerator codeGenerator = new CodeGeneratorBuilder()
                        .withGenerateType(generateType)
                        .withSourceString(inputData)
                        .build();
                codeGenerator.populate(spriteTable);
            }
        });

    }

    private void setEditorTableWidth() {
        switch(generateType) {
            case SPRITE:
                spriteTable.setRowHeight(40);
                break;
            case PLAY_FIELD:
                spriteTable.setRowHeight(48);
                break;
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void setSwitchTypeButtonText() {
        switchTypeButton.setText("Switch to " + generateType.getDisplayName());
    }

    private JPanel mainPanel;
    private JLabel titleLabel;
    private JTable spriteTable;
    private JButton generateCodeButton;
    private JTextArea codeTextArea;
    private JButton resetButton;
    private JButton aboutButton;
    private JButton switchTypeButton;
    private JButton loadFromDataButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
