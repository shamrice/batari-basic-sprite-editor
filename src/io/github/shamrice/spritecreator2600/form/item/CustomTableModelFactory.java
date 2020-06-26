package io.github.shamrice.spritecreator2600.form.item;

import io.github.shamrice.spritecreator2600.form.GenerateType;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CustomTableModelFactory {

    public static TableModel getTableModel(GenerateType generateType) {

        int rows = 0;
        int cols = 0;

        switch (generateType) {
            case SPRITE:
                rows = 8;
                cols = 8;
                break;

            case PLAY_FIELD:
                rows = 11;
                cols = 32;
                break;
        }

        return new DefaultTableModel(rows, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
