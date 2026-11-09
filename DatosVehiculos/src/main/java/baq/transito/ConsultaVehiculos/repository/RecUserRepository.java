/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baq.transito.ConsultaVehiculos.repository;


import baq.transito.ConsultaVehiculos.entities.RecUsers;
import baq.transito.ConsultaVehiculos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecUserRepository extends JpaRepository<RecUsers, Long> {

    @Query(value = "SELECT r FROM RecUsers r WHERE r.usuario = :usuario AND r.contrasena = :password")
    List<RecUsers> obtenerPorUsuarioClaveActivo(
            @Param("usuario") String documento,
            @Param("password") String password

    );


}