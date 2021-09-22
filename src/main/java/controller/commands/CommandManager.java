package controller.commands;

import controller.commands.admin.car.get.CarAddGetServletActionImpl;
import controller.commands.admin.car.get.CarHomeServletActionImpl;
import controller.commands.admin.car.get.CarUpdateGetServletActionImpl;
import controller.commands.admin.car.post.CarAddPostServletActionImpl;
import controller.commands.admin.car.post.CarDeleteServletActionImpl;
import controller.commands.admin.car.post.CarUpdatePostServletActionImpl;
import controller.commands.admin.label.get.LabelAddGetServletActionImpl;
import controller.commands.admin.label.get.LabelHomeServletActionImpl;
import controller.commands.admin.label.get.LabelUpdateGetServletActionImpl;
import controller.commands.admin.label.post.LabelAddPostServletActionImpl;
import controller.commands.admin.label.post.LabelDeletePostServletActionImpl;
import controller.commands.admin.label.post.LabelUpdatePostServletActionImpl;
import controller.commands.admin.level.get.LevelAddGetServletActionImpl;
import controller.commands.admin.level.get.LevelHomeServletActionImpl;
import controller.commands.admin.level.get.LevelUpdateGetServletActionImpl;
import controller.commands.admin.level.post.LevelAddPostServletActionImpl;
import controller.commands.admin.level.post.LevelDeleteServletActionImpl;
import controller.commands.admin.level.post.LevelUpdatePostServletActionImpl;
import controller.commands.admin.role.get.RoleAddGetServletActionImpl;
import controller.commands.admin.role.get.RoleHomeServletActionImpl;
import controller.commands.admin.role.get.RoleUpdateGetServletActionImpl;
import controller.commands.admin.role.post.RoleAddPostServletActionImpl;
import controller.commands.admin.role.post.RoleDeleteServletActionImpl;
import controller.commands.admin.role.post.RoleUpdatePostServletActionImpl;
import controller.commands.admin.user.get.UserHomeServletActionImpl;
import controller.commands.admin.user.post.UserDeleteServletActionImpl;
import controller.commands.general.get.MainPageGetServletActionImpl;
import controller.commands.general.post.ImageUploadServletActionImpl;
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
        commands.put(pr.getCommandsProperty("MAIN"), new MainPageGetServletActionImpl());
        commands.put(pr.getCommandsProperty("SIGN_IN"), new SignInGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_IN_POST"), new SignInPostServletAction());
        commands.put(pr.getCommandsProperty("SIGN_UP"), new SignUpGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_UP_POST"), new SignUpPostServletAction());
        commands.put(pr.getCommandsProperty("USER_MAIN"), new UserPageGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_OUT"), new UserSignOutServletAction());
        commands.put(pr.getCommandsProperty("UPLOAD_IMAGE_POST"), new ImageUploadServletActionImpl());
        // user
        commands.put(pr.getCommandsProperty("ADMIN_USER_HOME"), new UserHomeServletActionImpl());
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
        if (mapping.isEmpty()) {
            return "/";
        }
        if (mapping.endsWith("/")) {
            mapping = mapping.substring(0, mapping.length() - 1);
        }
        return mapping;
    }
}
