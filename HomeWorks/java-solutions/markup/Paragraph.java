package markup;

import java.util.List;

public class Paragraph extends AbstractTextElement implements ListedElement {
    public Paragraph(List<MarkupElement> content) {
        super(content);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "", "");
    }
}
