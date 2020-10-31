package org.montanajr.auth.dao.impl;

import org.montanajr.auth.dao.PermissionDAO;
import org.montanajr.auth.dao.mapper.PermissionMapper;
import org.montanajr.auth.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Repository
public class MybatisPermissionDAO implements PermissionDAO {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int deleteById(UUID id) {
        return permissionMapper.deleteById(id);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public Permission selectById(UUID id) {
        return permissionMapper.selectById(id);
    }

    @Override
    public void updateName(UUID id, String name) {
        permissionMapper.updateName(id, name);
    }

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public List<Permission> getPermissionList(Map paramMap) {
        return permissionMapper.selectByMap(paramMap);
    }
}
