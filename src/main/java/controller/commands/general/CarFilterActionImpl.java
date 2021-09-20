//package controller.commands.general;
//
//import controller.interfaces.ServletAction;
//import dao.CarDAO;
//import entity.Car;
//import entity.Label;
//import entity.Level;
//import service.CarService;
//import service.interfaces.MainService;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class CarFilterActionImpl implements ServletAction {
//    private final MainService<Car> carsService;
//
//    public CarFilterActionImpl() {
//        this.carsService = new CarService(new CarDAO());
//    }
//
//    @Override
//
//    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String labelId = req.getParameter("label_id");
//        String levelId = req.getParameter("level_id");
//        String priceFrom = req.getParameter("price_from");
//        String priceTo = req.getParameter("price_to");
//        // TODO: add validations to check empty values
//        try {
//            Car carFilterObject = Car.newBuilder()
//                    .setLabel(Label.newBuilder().setId(Integer.parseInt(labelId)).build())
//                    .setLevel(Level.newBuilder().setId(Integer.parseInt(levelId)).build())
//                    .setName(name)
//                    .setPriceFrom(Integer.parseInt(priceFrom))
//                    .setPriceTo(Integer.parseInt(priceTo)).build();
//
//            List<Car> foundList = carsService.getByItem(carFilterObject);
//            req.setAttribute("filterList", foundList);
//        } catch (Exception e) {
//            req.setAttribute("error", e.getMessage());
//        }
//        //TODO: replace to correct page
//        return "index";
//    }
//}
