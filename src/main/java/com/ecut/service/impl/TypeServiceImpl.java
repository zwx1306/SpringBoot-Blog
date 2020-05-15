package com.ecut.service.impl;

import com.ecut.dao.TypeDao;
import com.ecut.domain.Type;
import com.ecut.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;



    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }


    @Override
    public Type getType(Long id) {
        return typeDao.getTypeById(id);
    }


    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public List<Type> getAdminType() {
        return typeDao.getAdminType();
    }


    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }


    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }


    @Override
    public int deleteType(Long id) {
        return typeDao.deleteType(id);
    }
}
