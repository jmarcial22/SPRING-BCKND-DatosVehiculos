/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baq.transito.ConsultaVehiculos.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "APP_USERS") // Para evitar conflictos con palabras reservadas de Oracle
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    //@SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) // Cargar roles junto con el usuario
    @JoinTable(
        name = "USER_ROLES",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}