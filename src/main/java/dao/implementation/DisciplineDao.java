package dao.implementation;//package dao.implementation;

import model.Discipline;
import dao.interfaces.AbstractDao;

import java.util.List;

/**
 * Created by romab on 9/23/16.
 */
public class DisciplineDao extends AbstractDao {


    public Discipline create(Discipline obj) {
        return (Discipline) super.create(obj);
    }

    public Discipline update(Discipline obj) {
        return (Discipline) super.update(obj);
    }


    public void delete(Discipline obj) {
        super.delete(obj);
    }


    public Discipline read(int id) {
        return (Discipline) super.read(Discipline.class, id);
    }

    public List readAll() {
        return super.readAll(Discipline.class);
    }

}
