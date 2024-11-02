package com.larosa.librarysystem.controller;

import com.larosa.librarysystem.entity.User;
import com.larosa.librarysystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
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
        if (userRepository.findByStudentEmpId(user.getStudentEmpId()) != null) {
            model.addAttribute("user", user);
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
    public String uservalidation(@RequestParam(value = "searchKey", required = false) String searchKey
            , @RequestParam(value = "criteria", required = false) String criteria, Model model) {
        System.out.println("key:" + searchKey);
        System.out.println("search:" + criteria);
        List<User> users = new ArrayList<>();
        if(StringUtils.isEmpty(searchKey)){
            users = userRepository.findAll();
        }else if(StringUtils.isEmpty(criteria)){
            criteria = "studentEmpId";
            users = userRepository.findAllByStudentEmpId(searchKey);
        }else if("studentEmpId".equals(criteria)){
            users = userRepository.findAllByStudentEmpId(searchKey);
        }else if("status".equals(criteria)){
            users = userRepository.findAllByStatus(searchKey);
        }else if("name".equals(criteria)) {
            users = userRepository.findAllByFirstName(searchKey);
        }else if("userType".equals(criteria)) {
            users = userRepository.findAllByUserType(searchKey);
        }

        model.addAttribute("users", users);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("criteria", criteria);

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
