package com.microservice.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class ClearSensitiveHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post"; // Filtro de tipo "post" para ejecutarse después de recibir la respuesta.
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

        // Verifica si el encabezado "Mi-Encabezado-Sensible" está presente en la respuesta.
        if (ctx.getResponse().containsHeader("Mi-Encabezado-Sensible")) {
            // Elimina el encabezado de la respuesta.
            ctx.getResponse().setHeader("Mi-Encabezado-Sensible", null);
        }

        return null;
    }
}