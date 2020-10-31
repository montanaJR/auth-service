package org.montanajr.auth.dao.mapper;

import org.montanajr.auth.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PermissionMapper {

    int deleteById(@Param("id") UUID id);

    int insert(Permission record);

    Permission selectById(@Param("id") UUID id);

    List<Permission> selectAll();

    int updateById(Permission record);

    void updateName(UUID id, String newName);

    List<Permission> selectByMap(Map paraMap);
}
