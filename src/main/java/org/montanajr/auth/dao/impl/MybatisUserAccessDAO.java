package org.montanajr.auth.dao.impl;

import org.montanajr.auth.dao.UserAccessDAO;
import org.montanajr.auth.dao.mapper.UserAccessMapper;
import org.montanajr.auth.entity.UserAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class MybatisUserAccessDAO implements UserAccessDAO {

    @Autowired
    UserAccessMapper userAccessMapper;

    @Override
    public List<UserAccess> securitySelectByUserId(UUID userId) {
        return userAccessMapper.securitySelectByUserId(userId);
    }

    @Override
    public List<UserAccess> securitySelectByUserIdWithFakeDoc(UUID userId) {
        return userAccessMapper.securitySelectByUserIdWithFakeDoc(userId);
    }

    @Override
    public int securityInsertRecord(UserAccess record) {
        return userAccessMapper.securityInsertRecord(record);
    }

    @Override
    public int securityUpdateRecord(UserAccess record) {
        return userAccessMapper.securityUpdateRecord(record);
    }

    @Override
    public int deleteByUserId(UUID userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        return userAccessMapper.deleteByUserId(userId);
    }


}
