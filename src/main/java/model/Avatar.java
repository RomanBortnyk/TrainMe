package model;

import javax.persistence.*;
import java.io.File;

/**
 * Created by romab on 10/2/16.
 */
@Entity
@Table(name = "avatar")
public class Avatar implements Item {

    private int id;
    private byte[] image;

    public Avatar() {

    }

    public Avatar(byte[] image) {
        this.image = image;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "image", nullable = false)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }




}
