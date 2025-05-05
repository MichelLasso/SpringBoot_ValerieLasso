package com.adrian.demojpa.application.service;

import java.util.List;

import com.adrian.demojpa.domain.Rol;

public interface RolService {
    public List<Rol> finAllRolesByFilter(String filter, String value);
    public Rol createNewRole(String name);
    public Rol removeRol(Long id);
    public List<Rol> findAllRolesByFilter(String filter, String value);
    public Rol createNewRol(String name);
    //put
    public Rol updateRol(Long id, String name);
    //delete
    void deleteRol(Long id);
}
