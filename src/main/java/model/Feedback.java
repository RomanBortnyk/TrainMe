package model;

import javax.persistence.*;

/**
 * Created by romab on 9/24/16.
 */
@Entity
@Table(name = "feedback")
public class Feedback implements Item {

    private int id;
    private User author;
    private User user;
    private String description;

    public Feedback(){

    }

    public Feedback(User author, User user){
        this.author = author;
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
