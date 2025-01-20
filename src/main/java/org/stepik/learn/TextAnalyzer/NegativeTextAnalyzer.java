package org.stepik.learn.TextAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    String[] negative_text = {":(", "=(", ":|"};
    Label label;
    @Override
    protected Label getLabel() {
        return label;
    }

    @Override
    protected String[] getKeywords() {
        return negative_text;
    }

    @Override
    public Label processText(String text) {
        for(String str: negative_text) {
            if (text.contains(str)){
                label = Label.NEGATIVE_TEXT;
                return label;
            }
        }
        label = Label.OK;
        return label;
    }
}
