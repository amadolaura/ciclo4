/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.retouno.controller;

import com.cuatroa.retouno.model.User;
import com.cuatroa.retouno.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Laurita
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
    //se utiliza autowired para que spring se encarga de instanciar esta clase
    @Autowired
    /**
     * 
     */
    private UserService userService;
    
    /**
     * 
     * Metodo http getmapping
     * @return 
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    
    /**
     * 
     * Metodo postmapping, retorna un estado 201 created y en el mensaje va los datos del usuario
     * @param user
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }
    
    /**
     * 
     * Autenticar usuario le estoy indicando que el email y el password vienen por medio del url
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }   
    
    
}
