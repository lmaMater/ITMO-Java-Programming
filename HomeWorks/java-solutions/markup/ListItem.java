package markup;

import java.util.List;

public class ListItem extends AbstractTextElement {
    public ListItem(List<ListedElement> content) {
        super(content);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<li>", "</li>");
    }
}
