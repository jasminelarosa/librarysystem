package com.larosa.librarysystem.controller;

import com.larosa.librarysystem.entity.User;
import com.larosa.librarysystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

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
        User foundUser = userRepository.findByStudentEmpId(user.getStudentEmpId());
        if (foundUser == null) {
            model.addAttribute("invalidUserId", true);
            return "books/login"; // Return to form if username exists
        }
        if(user.getPassword().equals(foundUser.getPassword())) {
            if(foundUser.getStatus().equals("active")) {
                return "books/logbook";
            }else{
                model.addAttribute("inactiveUser", true);
            }
        }else{
            model.addAttribute("invalidPassword", true);
        }
        return "books/login";

    }

    @PostMapping(value = "register")
    public String saveRegister(User user, Model model) {
        model.addAttribute("user", user);
        if (userRepository.findByStudentEmpId(user.getStudentEmpId()) != null) {
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

    @GetMapping(value = "uservalidation")
    public String uservalidation(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "books/uservalidation";
    }

    @PostMapping(value = "users/update-status")
    public String saveRegister(@RequestParam("studentEmpId") String studentEmpId, @RequestParam("status") String status) {
        User findUser = userRepository.findByStudentEmpId(studentEmpId);
        findUser.setStatus(status);
        userRepository.save(findUser);
        return "redirect:/books/uservalidation";
    }
}
