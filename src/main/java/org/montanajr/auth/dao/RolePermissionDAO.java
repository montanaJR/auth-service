package org.montanajr.auth.dao;

import org.montanajr.auth.entity.RolePermission;

import java.util.List;
import java.util.UUID;

public interface RolePermissionDAO {

    int deleteById(Long id);

    Long insert(RolePermission record);

    List<RolePermission> selectByRoleId(UUID roleId);

    int updateById(RolePermission record);

    void deleteByRoleIdAndPermissionId(UUID rId, UUID pId);

}
