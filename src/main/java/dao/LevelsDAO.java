package dao;

import dao.interfaces.MainDAO;
import entity.Levels;

import java.sql.SQLException;
import java.util.List;

public class LevelsDAO implements MainDAO<Levels> {
    @Override
    public void addObject(Levels obj) {

    }

    @Override
    public void removeObject(int id) {

    }

    @Override
    public void updateObject(Levels obj) {

    }

    @Override
    public Levels getObjectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Levels> getObjects() {
        return null;
    }

    @Override
    public List<Levels> getByItem(Levels obj) {
        return null;
    }
}
