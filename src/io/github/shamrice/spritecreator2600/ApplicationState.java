package io.github.shamrice.spritecreator2600;

public class ApplicationState {

    public static int getPrevCol() {
        return prevCol;
    }

    public static int getPrevRow() {
        return prevRow;
    }

    public static void setPrevCol(int prevCol) {
        ApplicationState.prevCol = prevCol;
    }

    public static void setPrevRow(int prevRow) {
        ApplicationState.prevRow = prevRow;
    }

    private static int prevCol = -1;
    private static int prevRow = -1;
}
