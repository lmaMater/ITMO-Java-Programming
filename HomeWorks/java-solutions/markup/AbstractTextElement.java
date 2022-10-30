package markup;

import java.util.List;

public abstract class AbstractTextElement implements TextElement {
    private final List<? extends TextElement> textElements;

    public AbstractTextElement(List<? extends TextElement> textElements) {
        this.textElements = textElements;
    }

    public void toHtml(StringBuilder sb,
                           String leftMark,
                           String rightMark) {
        sb.append(leftMark);
        for (TextElement textElement : textElements) {
            textElement.toHtml(sb);
        }
        sb.append(rightMark);
    }
}
