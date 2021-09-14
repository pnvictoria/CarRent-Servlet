package service;

import entity.Levels;
import service.interfaces.MainService;

import java.sql.SQLException;
import java.util.List;

public class LevelsService implements MainService<Levels> {
    @Override
    public boolean addObject(Levels obj) {
        return false;
    }

    @Override
    public void deleteObject(int id) {

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
