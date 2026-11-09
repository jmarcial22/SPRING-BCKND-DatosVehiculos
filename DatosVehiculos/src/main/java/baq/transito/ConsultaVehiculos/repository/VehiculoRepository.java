/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baq.transito.ConsultaVehiculos.repository;


import baq.transito.ConsultaVehiculos.entities.RecUsers;
import baq.transito.ConsultaVehiculos.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query(value = "select t.nro_placa PLACA,a.desc_marca MARCA,i.desc_linea LINEA,l.modelo MODELO,\n" +
            "l.fecha_ingreso_tto FECHA_MAT,c.desc_clase CLASE,e.desc_carroceria CARROCERIA,s.desc_servicio SERVICIO, \n" +
            "case \n" +
            "when u.id_documento=1 then 'Cedula'when u.id_documento=2 then 'NIT' \n" +
            "when u.id_documento=3 then 'Cedula Extranjeria'when u.id_documento=4 then 'Tarjeta Identidad'\n" +
            "end tipo_doc,max(u.id_usuario) ID_PROPIETA,u.apellidos||' '||u.nombres nombres,u.direccion,u.telefono,u.celular,\n" +
            "w.nombre_ciudad,d.nombre_departamento,u.fmodifica_usuario \n" +
            "from quipux.lic_tto t \n" +
            "full outer join propietarios_vehiculo p on p.nro_placa=t.nro_placa \n" +
            "full outer join usuarios_tto u on u.id_usuario=p.id_usuario \n" +
            "inner join lic_tto l on l.nro_placa=t.nro_placa \n" +
            "inner join marca_vehiculos a on a.id_marca=l.id_marca \n" +
            "inner join tipo_linea i on i.id_linea=l.id_linea \n" +
            "inner join clase_vehiculos c on c.id_clase=l.id_clase \n" +
            "inner join tipo_carroceria e on e.id_carroceria=l.id_carroceria \n" +
            "inner join tipo_servicio s on s.id_servicio=l.id_servicio \n" +
            "FULL OUTER join ciudades w on w.id_ciudad=u.ciudad_dir \n" +
            "full outer join qx_ciudad q on q.id_ciudad_qx=w.id_ciudad_qx \n" +
            "FULL OUTER JOIN departamentos d on d.id_departamento_qx=q.id_departamento_qx \n" +
            "where l.id_estado in (1,12) and t.nro_placa = :placa \n" +
            "group by  t.nro_placa,a.desc_marca,i.desc_linea,c.desc_clase,l.modelo,e.desc_carroceria,\n" +
            "l.fecha_ingreso_tto,s.desc_servicio,u.apellidos,u.nombres,u.id_documento,u.direccion,\n" +
            "u.telefono,u.celular,w.nombre_ciudad,d.nombre_departamento,u.fmodifica_usuario", nativeQuery = true)
    List<Vehiculo> obtenerDatosVehiculo(
            @Param("placa") String placa

    );


}