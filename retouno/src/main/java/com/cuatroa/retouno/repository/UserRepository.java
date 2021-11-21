/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.retouno.repository;

import com.cuatroa.retouno.model.User;
import com.cuatroa.retouno.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laurita
 */
//
@Repository
public class UserRepository {
    
    // le dice a spring que cuando inicie la aplicacion se encargue de instanciar
    //implementa la interfaz
    @Autowired
    private UserCrudRepository userCrudRepository;

    //
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

        public User save(User user) {

            return userCrudRepository.save(user);

        }


        //consultas para validar la validación de email
       //existe un email, el usuario va a retornar true o falso dependiendo, 
       //true si el usuario existe y falso si no existe
        public boolean existeEmail(String email) {

            Optional<User> usuario = userCrudRepository.findByEmail(email);


            return !usuario.isEmpty();

        }

        //Autenticacion de usuario
        public Optional<User> autenticarUsuario(String email, String password) {

            return userCrudRepository.findByEmailAndPassword(email, password);

        }
}
