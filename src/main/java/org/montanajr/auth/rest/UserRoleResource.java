package org.montanajr.auth.rest;

import org.montanajr.auth.dto.RolePermissionDTO;
import org.montanajr.auth.entity.Permission;
import org.montanajr.auth.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/")
public class UserRoleResource {

    @Autowired
    SecurityService securityService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userRolePermissions")
    public Response getUserRolePermissions(@QueryParam("userId") String userId) {
        List<RolePermissionDTO> rolePermissions = securityService.getRolePermissionsByUserId(UUID.fromString(userId));
        return Response.ok(rolePermissions).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userPermissions")
    public Response getPermissionList(@QueryParam("userId") String userId) {
        List<Permission> permissionList = securityService.getPermissionListByUserId(userId);
        return Response.ok(permissionList).build();
    }
}
