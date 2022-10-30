package markup;

public class Text implements MarkupElement {
    private final String content;

    public Text(String content) {
        this.content = content;
    }

    @Override
    public void toHtml(StringBuilder sb) {
        sb.append(content);
    }
}
