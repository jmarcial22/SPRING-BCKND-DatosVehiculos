
package baq.transito.ConsultaVehiculos.controller;


import jakarta.validation.Valid;
import baq.transito.ConsultaVehiculos.payload.request.LoginRequest;
import baq.transito.ConsultaVehiculos.payload.request.SignupRequest;
import baq.transito.ConsultaVehiculos.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/DatosVehiculos/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.authenticateUser(loginRequest));
    }
}