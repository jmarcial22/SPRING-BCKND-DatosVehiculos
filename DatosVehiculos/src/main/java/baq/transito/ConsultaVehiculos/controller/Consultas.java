
package baq.transito.ConsultaVehiculos.controller;




import baq.transito.ConsultaVehiculos.Utils.StringMD;
import baq.transito.ConsultaVehiculos.entities.RecUsers;
import baq.transito.ConsultaVehiculos.entities.Vehiculo;
import baq.transito.ConsultaVehiculos.repository.RecUserRepository;
import baq.transito.ConsultaVehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/DatosVehiculos")
public class Consultas {
@Autowired
    RecUserRepository recUserRepository;
@Autowired
    VehiculoRepository vehiculoRepository;

    @GetMapping("/login/{usuario}/{password}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<RecUsers> userAccess(@PathVariable("usuario") String usuario,
                             @PathVariable("password") String password
                             )
    {
        return recUserRepository.obtenerPorUsuarioClaveActivo(usuario,
                StringMD.getStringMessageDigest(password, StringMD.MD5));

    }

    @GetMapping("/placa/{placa}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<Vehiculo> userAccess(@PathVariable("placa") String placa
    )
    {
        return vehiculoRepository.obtenerDatosVehiculo(placa);

    }


    /*
    @GetMapping("/licencia/{id}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<Licencias> obtenerLicencias(@PathVariable("id") String id) {
        System.out.println("Id que llegó: "+id);
        return licenciasRepository.obtenerLicencias(id);

    }

    @GetMapping("/estado_debido_cobrar/{placa}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<DebidoCobrar> obtenerDebidoCobrar(@PathVariable("placa") String placa) {
        System.out.println("Id que llegó: "+placa);
        return debidoCobrarRepository.obtenerDebidoCobrar(placa.toUpperCase());
    }

    @GetMapping("/estado_vehiculo/{placa}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<Vehiculo> obtenerVehiculo(@PathVariable("placa") String placa) {
        System.out.println("Id que llegó en estado_vehiculo: "+placa);
        return vehiculoRepository.obtenerVehiculo(placa);
    }

    @GetMapping("/tramites_identificador/{identificador}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<Tramites> obtenerTramitesPorIdentificador(@PathVariable("identificador") String identificador) {
        System.out.println("Id que llegó en listado tramites: "+identificador);
        return tramitesRepository.obtenerTramitesPorIdentificador(identificador);
    }

    @GetMapping("/tramites_recibo/{recibo}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<Tramites> obtenerTramitesPorRecibo(@PathVariable("recibo") String recibo) {
        System.out.println("Id que llegó en listado tramites recibo: "+recibo);
        return tramitesRepository.obtenerTramitesPorRecibo(recibo);
    }

    @GetMapping("/tipo_tramite/{tramite}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<TipoTramite> obtenerTipoTramite(@PathVariable("tramite") String tramite) {
        System.out.println("Id que llegó en listado tramites recibo: "+tramite);
        return tipoTramiteRepository.obtenerTipoTramite(tramite);
    }

    @GetMapping("/tarifas/{tramite}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<Tarifas> obtenerTarifasTramite(@PathVariable("tramite") String tramite) {
        System.out.println("Id que llegó en listado tarifas recibo: "+tramite);
        return tarifasRepository.obtenerTarifasPorTramite(tramite);
    }

    @GetMapping("/liencias_susp_canceladas/{identificador}")
    @PreAuthorize("hasRole('CONSULTA')")
    public List<LicenciasSuspendidasCanceladas> obtenerLicenciasSuspendidasCanceladas(@PathVariable("identificador") String identificador) {
        System.out.println("Id que llegó en listado tramites: "+identificador);
        return licenciasSuspendidasCanceladasRepository.obtenerLicenciasSuspendidasCanceladas(identificador);
    }

*/

}