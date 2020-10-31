package org.montanajr.auth.dto;

import lombok.Data;

import java.util.UUID;


@Data
public class UserRoleDTO {

    private UUID userId;

    private UUID roleId;

    private String name;

    private String description;
}
