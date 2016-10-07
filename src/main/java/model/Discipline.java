package model;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by romab on 9/24/16.
 */
@Entity
@Table(name = "discipline")
public class Discipline implements Item {
    private int id;
    private String name;
    private byte[] icon;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "icon")
    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }


}
