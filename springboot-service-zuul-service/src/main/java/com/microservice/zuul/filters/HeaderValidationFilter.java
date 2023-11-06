package com.microservice.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class HeaderValidationFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; // Filtro de tipo "pre" para ejecutarse antes de enviar la solicitud.
    }

    @Override
    public int filterOrder() {
        return 1; // Orden de ejecución del filtro.
    }

    @Override
    public boolean shouldFilter() {
        return true; // El filtro siempre se ejecutará.
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        // Verifica si el encabezado "Mi-Encabezado" está presente en la solicitud.
        String miEncabezado = ctx.getRequest().getHeader("Mi-Encabezado");

        if (miEncabezado == null || miEncabezado.isEmpty()) {
            // El encabezado no está presente o está vacío, toma medidas según tu requerimiento.
            ctx.setResponseStatusCode(400); // Código de respuesta HTTP 400 (Bad Request)
            ctx.setSendZuulResponse(false); // No envíes la solicitud a la ruta de destino
            ctx.setResponseBody("El encabezado 'Mi-Encabezado' es obligatorio"); // Mensaje de error en el cuerpo de la respuesta
        }

        return null;
    }
}