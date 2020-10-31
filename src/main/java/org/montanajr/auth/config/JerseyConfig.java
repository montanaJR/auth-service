package org.montanajr.auth.config;


import org.montanajr.auth.rest.ClientSecretResource;
import org.montanajr.auth.rest.SecurityResource;
import org.montanajr.auth.rest.UserRoleResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;


@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(RequestContextFilter.class);
        register(ClientSecretResource.class);
        register(SecurityResource.class);
        register(UserRoleResource.class);
    }
}