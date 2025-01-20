package org.stepik.learn.TextAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract Label getLabel();

    protected abstract String[] getKeywords();

    public Label processText(String text) {
        return getLabel();
    }
}
