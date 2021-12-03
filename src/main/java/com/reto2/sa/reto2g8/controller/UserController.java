/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.controller;

import com.reto2.sa.reto2g8.entity.Rol;
import com.reto2.sa.reto2g8.entity.User;
import com.reto2.sa.reto2g8.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */

@RestController 
@CrossOrigin(origins="*" ,methods={RequestMethod.GET,RequestMethod.POST,
                                   RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/user/")
public class UserController {
    
    @Autowired
    private UserService service;
    
    @GetMapping("/all")    
    public List<User> findAllUser(){
        return service.getUser();        
    }
    
    @GetMapping("/{correo}")    
    public boolean findUserCorreo(@PathVariable String correo){
        return (service.getFindByEmail(correo)!=null)?true:false;
    }
    
    @GetMapping("/{correo}/{password}")    
    public User validar(@PathVariable String correo,
                           @PathVariable String password){        
        return service.validar(correo, password);
    }
 
    @PostMapping("/new")
    public ResponseEntity addPersonal(@RequestBody User user){
        service.saveUser(user);
        return ResponseEntity.status(201).build();
    }
    
    
    
    
    
}
