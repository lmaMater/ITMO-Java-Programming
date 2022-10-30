package markup;

import java.util.List;

public class Strikeout extends AbstractTextElement implements MarkupElement {
    public Strikeout(List<MarkupElement> content) {
        super(content);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<s>", "</s>");
    }
}
