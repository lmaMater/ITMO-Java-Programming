package markup;

import java.util.List;

public class UnorderedList extends AbstractTextElement implements ListedElement {
    public UnorderedList(List<ListItem> content) {
        super(content);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<ul>", "</ul>");
    }
}