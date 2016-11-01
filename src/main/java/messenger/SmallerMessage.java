package messenger;

/**
 * Created by romab on 11/1/16.
 */
public class SmallerMessage {

    private int authorId;
    private String authorName;
    private String text;

    public SmallerMessage(int authorId, String text, String authorName) {
        this.authorId = authorId;
        this.text = text;
        this.authorName = authorName;
    }


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
