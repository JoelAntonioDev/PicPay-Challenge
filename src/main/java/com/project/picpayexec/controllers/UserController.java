package com.project.picpayexec.controllers;

import com.project.picpayexec.domain.model.User;
import com.project.picpayexec.dtos.UserDTO;
import com.project.picpayexec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> adicionarUser(@RequestBody UserDTO userDTO) {
        User newUser = userService.adicionar(userDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> BuscarTodos() {
        List<User> users = this.userService.listar();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/userId")
    public ResponseEntity<User> BuscarUserByID(@RequestParam Long userId) {
        User usuario = userService.findUserById(userId);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
