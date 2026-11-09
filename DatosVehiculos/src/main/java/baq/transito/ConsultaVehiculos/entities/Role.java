/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baq.transito.ConsultaVehiculos.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import baq.transito.ConsultaVehiculos.enums.ERole;

@Entity
@Table(name = "APP_ROLES") // Para evitar conflictos con palabras reservadas de Oracle
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    //@SequenceGenerator(name = "role_seq", sequenceName = "ROLE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}