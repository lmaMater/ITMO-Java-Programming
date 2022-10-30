package markup;

import java.util.List;

public class OrderedList extends AbstractTextElement implements ListedElement {
    public OrderedList(List<ListItem> content) {
        super(content);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<ol>", "</ol>");
    }
}