package com.gmail.controller;

import com.gmail.dto.User;
import com.gmail.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Space on 17.05.2019.
 */
@Controller
public class UserController {
    @Autowired
    private UserDto userDto;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        userDto.save(user);
        return "index";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("user") User user) {
        userDto.deleteById(user.getId());
        return "redirect:/index";
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.POST)
    public ModelAndView showAllUsers() {
        return new ModelAndView("result", "users", userDto.getAll());
    }
}
