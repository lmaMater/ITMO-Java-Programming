package markup;

import java.util.List;

public class Strong extends AbstractTextElement implements MarkupElement {
    public Strong(List<MarkupElement> content) {
        super(content);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<strong>", "</strong>");
    }
}
