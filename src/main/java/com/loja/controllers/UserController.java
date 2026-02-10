package com.loja.controllers;

import com.loja.model.User;
import com.loja.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/createUser")
    public User CriarUsuario(@RequestBody User user) {
        return userServices.CreatingUser(user);
    }

    @GetMapping("/listUser")
    public List<User> ListarUsuarios() {
        return userServices.listUser();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id) {
        return userServices.findById(id);
    }

    @PutMapping("/updateUser/{id}")
    public User UpdateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userServices.UpdateUser(id, updatedUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServices.deleteUser(id);
    }
}
