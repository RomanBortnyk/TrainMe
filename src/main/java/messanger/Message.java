package messanger;

/**
 * Created by romab on 10/28/16.
 */
public class Message {

    private String author;
    private String text;
    private String chatId;


    public Message(String author, String text, String chatId) {
        this.author = author;
        this.text = text;
        this.chatId = chatId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
