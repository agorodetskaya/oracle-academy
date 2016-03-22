package controller;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
public class UserListController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String home() throws IOException, ServletException {
        return "redirect:/users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String gotoUsers(Model model) throws IOException, ServletException {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("user", new User());
        model.addAttribute("roles", Role.values());
        return "userList";
    }
}
