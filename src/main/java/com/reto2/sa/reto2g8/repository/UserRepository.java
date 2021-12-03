/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.repository;

import com.reto2.sa.reto2g8.entity.Departamento;
import com.reto2.sa.reto2g8.entity.Empleado;
import com.reto2.sa.reto2g8.entity.User;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author DELL
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    @Query("SELECT d FROM User d WHERE email=?1")
    public User findByEmail(String correo);
    @Query("SELECT d FROM User d WHERE email=?1 and password=?2")
    public User validar(String correo,String password);
}

