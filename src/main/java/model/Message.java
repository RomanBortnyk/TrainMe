package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by romab on 9/24/16.
 */
@Entity
@Table(name = "message")
public class Message implements Item{
    private int id;
    private String text;
    private Timestamp createdAt;
    private Chat chat;
    private User user;

    public Message(){

    }

    public Message(String text, Chat chat, User user) {
        this.text = text;
        this.chat = chat;
        this.user = user;
        this.createdAt = new Timestamp(Calendar.getInstance().getTime().getTime());

    }


    @ManyToOne
    @JoinColumn(name = "author_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "chat_id")
    public Chat getChat() {
        return chat;
    }


    public void setChat(Chat chat) {
        this.chat = chat;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


}
