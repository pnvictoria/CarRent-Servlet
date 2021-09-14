package controller;

import controller.commands.admin.cars.*;
import controller.commands.admin.role.*;
import controller.commands.admin.users.*;
import controller.interfaces.ServletAction;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CommandManager {

    private HashMap<String, ServletAction> commands = new HashMap<>();

    public CommandManager() {
        // user
        commands.put("/admin/user/home", new UserHomeServletActionImpl());
        commands.put("/admin/user/add", new UserAddServletActionImpl());
        commands.put("/admin/user/update", new UserUpdateServletActionImpl());
        commands.put("/admin/user/delete", new UserDeleteServletActionImpl());
        // car
        commands.put("/admin/car/home", new CarHomeServletActionImpl());
        commands.put("/admin/car/add", new CarAddServletActionImpl());
        commands.put("/admin/car/update", new CarUpdateServletActionImpl());
        commands.put("/admin/car/delete", new CarDeleteServletActionImpl());
        // role
        commands.put("/admin/role/home", new RoleHomeServletActionImpl());
        commands.put("/admin/role/add", new RoleAddServletActionImpl());
        commands.put("/admin/role/update", new RoleUpdateServletActionImpl());
        commands.put("/admin/role/delete", new RoleDeleteServletActionImpl());
    }

    public ServletAction getCommand(HttpServletRequest request) {
        String command = getMapping(request);
        if (commands.get(command) == null) {
            return commands.get("/");
        }
        return commands.get(command);
    }

    public String getMapping(HttpServletRequest request) {
        String mapping = request.getRequestURI().substring(request.getContextPath().length());
        if (mapping.endsWith("/")) {
            mapping = mapping.substring(0, mapping.length() - 1);
        }
        return mapping;
    }
}
