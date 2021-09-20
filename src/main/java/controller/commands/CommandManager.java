package controller.commands;

import controller.commands.admin.cars.CarAddServletActionImpl;
import controller.commands.admin.cars.CarDeleteServletActionImpl;
import controller.commands.admin.cars.CarHomeServletActionImpl;
import controller.commands.admin.cars.CarUpdateServletActionImpl;
import controller.commands.admin.labels.get.LabelAddGetServletActionImpl;
import controller.commands.admin.labels.post.LabelDeletePostServletActionImpl;
import controller.commands.admin.labels.get.LabelHomeServletActionImpl;
import controller.commands.admin.labels.get.LabelUpdateGetServletActionImpl;
import controller.commands.admin.labels.post.LabelAddPostServletActionImpl;
import controller.commands.admin.labels.post.LabelUpdatePostServletActionImpl;
import controller.commands.admin.levels.LevelAddServletActionImpl;
import controller.commands.admin.levels.LevelDeleteServletActionImpl;
import controller.commands.admin.levels.LevelHomeServletActionImpl;
import controller.commands.admin.levels.LevelUpdateServletActionImpl;
import controller.commands.admin.roles.RoleAddServletActionImpl;
import controller.commands.admin.roles.RoleDeleteServletActionImpl;
import controller.commands.admin.roles.RoleHomeServletActionImpl;
import controller.commands.admin.roles.RoleUpdateServletActionImpl;
import controller.commands.admin.users.UserAddServletActionImpl;
import controller.commands.admin.users.UserDeleteServletActionImpl;
import controller.commands.admin.users.UserHomeServletActionImpl;
import controller.commands.admin.users.UserUpdateServletActionImpl;
import controller.commands.user.sign_in.SignInGetServletAction;
import controller.commands.user.sign_in.SignInPostServletAction;
import controller.commands.user.sign_up.SignUpGetServletAction;
import controller.commands.user.sign_up.SignUpPostServletAction;
import controller.interfaces.ServletAction;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CommandManager {

    public static final HashMap<String, ServletAction> commands = new HashMap<>();

    public CommandManager() {
        ReadPropertiesFile pr = new ReadPropertiesFile();

        // user
        commands.put(pr.getCommandsProperty("SIGN_IN"), new SignInGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_IN_POST"), new SignInPostServletAction());
        commands.put(pr.getCommandsProperty("SIGN_UP"), new SignUpGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_UP_POST"), new SignUpPostServletAction());
        // user
        commands.put(pr.getCommandsProperty("ADMIN_USER_HOME"), new UserHomeServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_USER_ADD"), new UserAddServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_USER_UPDATE"), new UserUpdateServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_USER_DELETE"), new UserDeleteServletActionImpl());
        // car
        commands.put(pr.getCommandsProperty("ADMIN_CAR_HOME"), new CarHomeServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_CAR_ADD"), new CarAddServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_CAR_UPDATE"), new CarUpdateServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_CAR_DELETE"), new CarDeleteServletActionImpl());
        // role
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_HOME"), new RoleHomeServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_ADD"), new RoleAddServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_UPDATE"), new RoleUpdateServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_DELETE"), new RoleDeleteServletActionImpl());
        // label
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_HOME"), new LabelHomeServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_ADD"), new LabelAddGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_ADD_POST"), new LabelAddPostServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_UPDATE"), new LabelUpdateGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_UPDATE_POST"), new LabelUpdatePostServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_DELETE"), new LabelDeletePostServletActionImpl());
        // level
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_HOME"), new LevelHomeServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_ADD"), new LevelAddServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_UPDATE"), new LevelUpdateServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_DELETE"), new LevelDeleteServletActionImpl());
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
