package org.montanajr.auth.dao.impl;

import org.montanajr.auth.dao.RolePermissionDAO;
import org.montanajr.auth.dao.mapper.RolePermissionMapper;
import org.montanajr.auth.entity.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
public class MybatisRolePermissionDAO implements RolePermissionDAO {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int deleteById(Long id) {
        return rolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Long insert(RolePermission record) {
        rolePermissionMapper.insert(record);
        return record.getId();
    }

    @Override
    public List<RolePermission> selectByRoleId(UUID roleId) {
        return rolePermissionMapper.selectByRoleId(roleId);
    }

    @Override
    public int updateById(RolePermission record) {
        return rolePermissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public void deleteByRoleIdAndPermissionId(UUID rId, UUID pId) {
        rolePermissionMapper.deleteByRoleIdAndPermissionId(rId, pId);
    }

}
