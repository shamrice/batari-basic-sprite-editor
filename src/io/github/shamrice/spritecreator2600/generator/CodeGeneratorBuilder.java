package io.github.shamrice.spritecreator2600.generator;

import javax.swing.*;

public class CodeGeneratorBuilder {

    private GenerateType generateType;
    private JTable editorTable;
    private String sourceString;

    public CodeGeneratorBuilder() {}

    public CodeGeneratorBuilder withGenerateType(GenerateType generateType) {
        this.generateType = generateType;
        return this;
    }

    public CodeGeneratorBuilder withEditorTable(JTable editorTable) {
        this.editorTable = editorTable;
        return this;
    }

    public CodeGeneratorBuilder withSourceString(String sourceString) {
        this.sourceString = sourceString;
        return this;
    }

    public CodeGenerator build() {

        CodeGenerator codeGenerator;

        if (generateType == GenerateType.SPRITE) {
            codeGenerator = new SpriteCodeGenerator();
        } else {
            codeGenerator = new PlayFieldCodeGenerator();
        }

        codeGenerator.setEditorTable(editorTable);
        codeGenerator.setInputString(sourceString);

        return codeGenerator;
    }


}
