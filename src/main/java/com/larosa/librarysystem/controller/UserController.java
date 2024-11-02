package com.larosa.librarysystem.controller;

import com.larosa.librarysystem.entity.User;
import com.larosa.librarysystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "books")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping(value = "login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user );
        return "books/login";
    }

    @PostMapping(value = "login")
    public String processLogin(User user, Model model) {
        User findUser = userRepository.findByStudentId(user.getStudentId());
        if (findUser == null) {
            model.addAttribute("invalidUserId", true);
            return "books/login"; // Return to form if username exists
        }
        if(user.getPassword().equals(findUser.getPassword())) {
            return "books/logbook";
        }
        model.addAttribute("invalidPassword", true);
        return "books/login";

    }

    @PostMapping(value = "register")
    public String saveRegister(User user, Model model) {
        model.addAttribute("user", user);
        if (userRepository.findByStudentId(user.getStudentId()) != null) {
            model.addAttribute("studentIdExists", true);
            return "books/register"; // Return to form if username exists
        }

        userRepository.save(user);
        return "redirect:/books/login";
    }

    @GetMapping(value = "register")
    public String getRegister(Model model) {
        User user = new User();
        model.addAttribute("user", user );
        return "books/register";
    }
}
