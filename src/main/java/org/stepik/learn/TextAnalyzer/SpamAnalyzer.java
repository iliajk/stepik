package org.stepik.learn.TextAnalyzer;

public class SpamAnalyzer extends KeywordAnalyzer {
    private final String[] keywords;
    private Label label = null;

    public SpamAnalyzer(String[] words) {
        this.keywords = words;
    }

    @Override
    public Label processText(String text) {
        for(String str: keywords) {
            if (text.contains(str)){
                label = Label.SPAM;
                return label;
            }
        }
        label = Label.OK;
        return label;
    }

    @Override
    protected Label getLabel() {
        return label;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }
}
