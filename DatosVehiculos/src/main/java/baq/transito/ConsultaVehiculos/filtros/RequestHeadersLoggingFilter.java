/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baq.transito.ConsultaVehiculos.filtros;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.stream.Collectors;

@Component
@Order(1) // Asegura que este filtro se ejecute antes que otros, como el de Spring Security
public class RequestHeadersLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        
        System.out.println("--- Headers de la solicitud entrante ---");
        
        // Obtener todos los nombres de los headers
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        
        // Iterar sobre los headers y mostrarlos
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = httpServletRequest.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
            
            // Si quieres solo verificar el de autorización
            if ("authorization".equalsIgnoreCase(headerName)) {
                System.out.println("-> ¡Header Authorization encontrado! Valor: " + headerValue);
            }
        }
        System.out.println("---------------------------------------");
        
        // Continuar la cadena de filtros para que la solicitud sea procesada
        chain.doFilter(request, response);
    }
}