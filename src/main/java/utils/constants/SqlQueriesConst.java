package utils.constants;

public class SqlQueriesConst {
    public static final String INSERT_CAR = "INSERT INTO car.cars(name, price, jpg, level_id, label_id, \"desc\") VALUES (?, ?, ?, ?, ?, ?);";
    public static final String SELECT_ALL_CARS = "SELECT cr.*, lv.id as lv_id, lv.name as level_name, lb.name as lablel_name, lb.id as lb_id FROM car.cars cr, car.levels lv, car.labels lb WHERE cr.level_id = lv.id and cr.label_id = lb.id;";
    public static final String SELECT_CAR_BY_ID = "SELECT id, name, price, jpg, level_id, label_id, \"desc\" FROM car.cars WHERE id = ?;";
    public static final String UPDATE_CAR_BY_ID = "UPDATE car.cars SET name=?, price=?, jpg=?, level_id=?, label_id=?, \"desc\"=? WHERE id=?;";
    public static final String DELETE_CAR_BY_ID = "DELETE FROM car.cars WHERE id = ?;";


}
