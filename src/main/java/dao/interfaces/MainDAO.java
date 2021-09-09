package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface MainDAO<T> {
    /**
     * the method for inserting Object to Data Base
     * @param obj
     */
    void addObject(T obj);

    /**
     * the method for deleting Object from Data Base
     * @param id
     */
    void removeObject(int id);

    /**
     * the method for update Object in Data Base
     * @param obj
     */
    void updateObject(T obj);

    /**
     * the method for getting objects from Data Base
     * @return
     */

    T getObjectById(int id) throws SQLException;

    List<T> getObjects();

    List<T> getByItem(T obj);
}
