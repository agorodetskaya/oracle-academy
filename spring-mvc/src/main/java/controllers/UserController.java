package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String gotoAddUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request, Model model) throws IOException, ServletException {
        /*String firstName = request.getParameter()*/
        User user = (User) model;
        userService.printUser(user);
        return "addUser";
    }

    @RequestMapping(value = "/users")
    public String gotoUsers(Model model, HttpServletRequest request) throws IOException, ServletException {
        if (request.getPart("newUser") != null) {
            addUser(request, model);
        }
        List<User> users = userService.getAll();
        model.addAllAttributes(users);
        return "userList";
    }

    @RequestMapping("update")
    public String updateUser() {
        return "addUser";
    }
}
