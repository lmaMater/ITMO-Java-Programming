package markup;

import java.util.List;

public class Emphasis extends AbstractTextElement implements MarkupElement {
    public Emphasis(List<MarkupElement> content) {
        super(content);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<em>", "</em>");
    }
}
