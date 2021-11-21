/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cuatroa.retouno.repository.crud;

import com.cuatroa.retouno.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * El crud va a la base de datos
 * @author Laurita
 */
public interface UserCrudRepository extends CrudRepository<User, Integer>{
    //La clase Optional indica que esta consulta puede retornar una consulta o no, metodo de busca 
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
