package baq.transito.ConsultaVehiculos.security.jwt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class SecurityContextInspectorFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityContextInspectorFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            logger.info("SecurityContextInspectorFilter######✅ Contexto de Seguridad ANTES del controlador: Autenticado como " + authentication.getName());
            logger.info("SecurityContextInspectorFilter######Roles del usuario: " + authentication.getAuthorities());
        } else {
            logger.warn("SecurityContextInspectorFilter######❌ Contexto de Seguridad ANTES del controlador: No se ha encontrado autenticación.");
        }

        filterChain.doFilter(request, response);
    }
}