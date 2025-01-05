package org.example;

public class TextFormat {

    public static void main(String[] args){

        TextEditor textEditor = new TextEditor();
        textEditor.setTextFormatter(new UpperCaseFormatter());
        textEditor.formatText("TESTTT");

    }

}

interface TextFormatter{

    public void formatText(String text);
}

class UpperCaseFormatter implements TextFormatter{

    @Override
    public void formatText(String text){
        System.out.println("text-format | " + text.toUpperCase());
    };

}

class LowerCaseFormatter implements TextFormatter{

    @Override
    public void formatText(String text){
        System.out.println("text-format | " + text.toLowerCase());
    };

}

class CamelCaseFormatter implements TextFormatter {

    @Override
    public void formatText(String text) {
        System.out.println("text-format | Camel Case");
    };


}

class TextEditor {

    private TextFormatter textFormatter;

    public void setTextFormatter(TextFormatter textFormatter) {

        this.textFormatter = textFormatter;

    }

    public void formatText(String text) {

        if (textFormatter == null) {
            throw new IllegalArgumentException("No format found");
        }

        this.textFormatter.formatText(text);

    }
}


