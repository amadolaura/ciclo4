/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cuatroa.retouno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * nos permite reconocer la ceración de una tabla
 * @author Laurita
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
//el user_email unico y por esto no se pueda repetir
@Table(name="user",indexes = @Index(name = "indx_email", columnList="user_email", unique = true))
public class User {
    
    @Id
    //Para que el id sea autogenerado
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_email", nullable = false, length = 50)
    private String email;
    @NonNull
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;
    @NonNull
    @Column(name = "user_name", nullable = false, length = 80)
    private String name;
    
}
