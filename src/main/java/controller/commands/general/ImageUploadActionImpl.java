package controller.commands.general;

import controller.interfaces.ServletAction;
import dao.UserDAO;
import entity.User;
import service.UserService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageUploadActionImpl implements ServletAction {
    private String USER_PAGE;
    private MainService<User> userService;

    public ImageUploadActionImpl() {
        userService = new UserService(new UserDAO());
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        USER_PAGE = propertyPage.getCommandsProperty("USER_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            Part filePart = req.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            String uploadPath = req.getServletContext().getRealPath("") + File.separator + "main" + File.separator + "upload";

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                Files.createDirectory(uploadDir.toPath());
            }

            try {
                filePart.write(uploadPath + File.separator + fileName);
            } catch (FileNotFoundException fne) {
                fne.printStackTrace();
                req.setAttribute("message", "There was an error: " + fne.getMessage());
            }
            User user = (User) req.getSession().getAttribute("user");
            User updatedUser = User.newBuilder()
                    .setId(user.getId())
                    .setEmail(user.getEmail())
                    .setPassword(user.getPassword())
                    .setName(user.getName())
                    .setSurname(user.getSurname())
                    .setSex(user.isSex())
                    .setDate(user.getDate())
                    .setAvatar(fileName)
                    .setRole(user.getRole())
                    .build();

            userService.updateObject(updatedUser);
            req.getSession().setAttribute("user", updatedUser);

            return USER_PAGE;
        } catch (IOException e) {
            e.printStackTrace();
            return USER_PAGE;
        }
    }
}
