package controller.commands.admin.cars.get;

import controller.interfaces.ServletAction;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarAddGetServletActionImpl implements ServletAction {
    private final String ADMIN_CAR_ADD_PAGE;

    public CarAddGetServletActionImpl() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_CAR_ADD_PAGE = propertyPage.getPageProperty("ADMIN_CAR_ADD_PAGE");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return ADMIN_CAR_ADD_PAGE;
    }
}
