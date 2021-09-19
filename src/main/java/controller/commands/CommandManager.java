package controller.commands;

import controller.commands.admin.cars.*;
import controller.commands.admin.labels.LabelAddServletActionImpl;
import controller.commands.admin.labels.LabelDeleteServletActionImpl;
import controller.commands.admin.labels.LabelHomeServletActionImpl;
import controller.commands.admin.labels.LabelUpdateServletActionImpl;
import controller.commands.admin.levels.LevelAddServletActionImpl;
import controller.commands.admin.levels.LevelDeleteServletActionImpl;
import controller.commands.admin.levels.LevelHomeServletActionImpl;
import controller.commands.admin.levels.LevelUpdateServletActionImpl;
import controller.commands.admin.roles.*;
import controller.commands.admin.users.*;
import controller.commands.user.sign_in.SignInGetServletAction;
import controller.commands.user.sign_in.SignInPostServletAction;
import controller.commands.user.sign_up.SignUpGetServletAction;
import controller.commands.user.sign_up.SignUpPostServletAction;
import controller.interfaces.ServletAction;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CommandManager {

    private HashMap<String, ServletAction> commands = new HashMap<>();

    public CommandManager() {
        // user
        commands.put("/sign-in", new SignInGetServletAction());
        commands.put("/sign-in/post", new SignInPostServletAction());
        commands.put("/sign-up", new SignUpGetServletAction());
        commands.put("/sign-un/post", new SignUpPostServletAction());

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
        // label
        commands.put("/admin/label/home", new LabelHomeServletActionImpl());
        commands.put("/admin/label/add", new LabelAddServletActionImpl());
        commands.put("/admin/label/update", new LabelUpdateServletActionImpl());
        commands.put("/admin/label/delete", new LabelDeleteServletActionImpl());
        // level
        commands.put("/admin/level/home", new LevelHomeServletActionImpl());
        commands.put("/admin/level/add", new LevelAddServletActionImpl());
        commands.put("/admin/level/update", new LevelUpdateServletActionImpl());
        commands.put("/admin/level/delete", new LevelDeleteServletActionImpl());
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
