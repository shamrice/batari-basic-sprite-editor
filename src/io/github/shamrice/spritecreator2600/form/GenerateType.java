package io.github.shamrice.spritecreator2600.form;

public enum GenerateType {
    SPRITE("Sprite Mode"),
    PLAY_FIELD("Play Field Mode");

    private final String displayName;

    GenerateType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

}
