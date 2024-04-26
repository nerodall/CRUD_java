package ru.gb.my_first_crud.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.my_first_crud.model.User;
import ru.gb.my_first_crud.service.UserService;

import java.util.List;

@Controller
@Log
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        //log.info("get users to List done!");
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
       // log.info("get user create done!");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
       // log.info("user save complete!");
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        //log.info("get user delete");
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String getUser (Model model,User user){
        model.addAttribute("users",user);
        //log.info("get user update");
        return "user-update";
    }

    @PostMapping("/user-update/{id}")
    public String updateUser (User user){
        userService.updateUser(user);
      //  log.info("get user update by id");
        return "redirect:/users";
    }

    @RequestMapping("/")
    public String redirectIndex(){
        return "redirect:/users";
    }
}
