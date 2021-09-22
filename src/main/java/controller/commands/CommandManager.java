package controller.commands;

import controller.commands.admin.cars.get.CarAddGetServletActionImpl;
import controller.commands.admin.cars.get.CarHomeServletActionImpl;
import controller.commands.admin.cars.get.CarUpdateGetServletActionImpl;
import controller.commands.admin.cars.post.CarAddPostServletActionImpl;
import controller.commands.admin.cars.post.CarDeleteServletActionImpl;
import controller.commands.admin.cars.post.CarUpdatePostServletActionImpl;
import controller.commands.admin.labels.get.LabelAddGetServletActionImpl;
import controller.commands.admin.labels.get.LabelHomeServletActionImpl;
import controller.commands.admin.labels.get.LabelUpdateGetServletActionImpl;
import controller.commands.admin.labels.post.LabelAddPostServletActionImpl;
import controller.commands.admin.labels.post.LabelDeletePostServletActionImpl;
import controller.commands.admin.labels.post.LabelUpdatePostServletActionImpl;
import controller.commands.admin.levels.get.LevelAddGetServletActionImpl;
import controller.commands.admin.levels.get.LevelHomeServletActionImpl;
import controller.commands.admin.levels.get.LevelUpdateGetServletActionImpl;
import controller.commands.admin.levels.post.LevelAddPostServletActionImpl;
import controller.commands.admin.levels.post.LevelDeleteServletActionImpl;
import controller.commands.admin.levels.post.LevelUpdatePostServletActionImpl;
import controller.commands.admin.roles.get.RoleAddGetServletActionImpl;
import controller.commands.admin.roles.get.RoleHomeServletActionImpl;
import controller.commands.admin.roles.get.RoleUpdateGetServletActionImpl;
import controller.commands.admin.roles.post.RoleAddPostServletActionImpl;
import controller.commands.admin.roles.post.RoleDeleteServletActionImpl;
import controller.commands.admin.roles.post.RoleUpdatePostServletActionImpl;
import controller.commands.admin.users.get.UserAddServletActionImpl;
import controller.commands.admin.users.get.UserHomeServletActionImpl;
import controller.commands.admin.users.get.UserUpdateServletActionImpl;
import controller.commands.admin.users.post.UserDeleteServletActionImpl;
import controller.commands.general.ImageUploadActionImpl;
import controller.commands.user.page.UserPageGetServletAction;
import controller.commands.user.sign_in.SignInGetServletAction;
import controller.commands.user.sign_in.SignInPostServletAction;
import controller.commands.user.sign_out.UserSignOutServletAction;
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
        // general
        commands.put(pr.getCommandsProperty("SIGN_IN"), new SignInGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_IN_POST"), new SignInPostServletAction());
        commands.put(pr.getCommandsProperty("SIGN_UP"), new SignUpGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_UP_POST"), new SignUpPostServletAction());
        commands.put(pr.getCommandsProperty("USER_PAGE"), new UserPageGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_OUT"), new UserSignOutServletAction());
        commands.put(pr.getCommandsProperty("UPLOAD_IMAGE_POST"), new ImageUploadActionImpl());
        // user
        commands.put(pr.getCommandsProperty("ADMIN_USER_HOME"), new UserHomeServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_USER_ADD"), new UserAddServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_USER_UPDATE"), new UserUpdateServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_USER_DELETE"), new UserDeleteServletActionImpl());
        // car
        commands.put(pr.getCommandsProperty("ADMIN_CAR_HOME"), new CarHomeServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_CAR_ADD"), new CarAddGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_CAR_ADD_POST"), new CarAddPostServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_CAR_UPDATE"), new CarUpdateGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_CAR_UPDATE_POST"), new CarUpdatePostServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_CAR_DELETE"), new CarDeleteServletActionImpl());
        // role
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_HOME"), new RoleHomeServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_ADD"), new RoleAddGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_ADD_POST"), new RoleAddPostServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_UPDATE"), new RoleUpdateGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_UPDATE_POST"), new RoleUpdatePostServletActionImpl());
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
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_ADD"), new LevelAddGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_ADD_POST"), new LevelAddPostServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_UPDATE"), new LevelUpdateGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_UPDATE_POST"), new LevelUpdatePostServletActionImpl());
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
