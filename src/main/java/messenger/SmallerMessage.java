package messenger;

/**
 * Created by romab on 11/1/16.
 */
public class SmallerMessage {

    private int authorId;
    private String authorName;
    private String text;
    private int chatId;

    public SmallerMessage(int authorId, String text, String authorName) {
        this.authorId = authorId;
        this.text = text;
        this.authorName = authorName;
    }

    public SmallerMessage() {

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }
}
