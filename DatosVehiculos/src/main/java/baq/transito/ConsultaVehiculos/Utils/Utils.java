package baq.transito.ConsultaVehiculos.Utils;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Calendar;
import java.util.Date;
public class Utils {

    public static Date obtenerFechaActual()
    {
        Calendar calendar;
        calendar = Calendar.getInstance();
        return calendar.getTime();
    }
    public static String getClientIp(HttpServletRequest request) {
        // Encabezado estándar para proxies reversos
        String ipAddress = request.getHeader("X-Forwarded-For");

        // Si el encabezado no está presente, se usa la dirección remota directa
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

        // Si hay múltiples IPs (lista de proxies), se toma la primera
        if (ipAddress != null && ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0].trim();
        }
        return ipAddress;
    }
}
