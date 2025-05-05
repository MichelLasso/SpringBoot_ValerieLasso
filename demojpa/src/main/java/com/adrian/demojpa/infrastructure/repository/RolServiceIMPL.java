package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.adrian.demojpa.application.service.RolService;
import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.infrastructure.error.RolDuplicateException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RolServiceIMPL implements RolService{
    private final RoleRepository roleRepository;

    public RolServiceIMPL(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Rol removeRol(Long id) {
        Optional<Rol> rol= roleRepository.findById(id);
        /*if(rol.isPresent() && rol.get().getPersons().isEmpty()){
            roleRepository.delete(rol.get());
            return rol.get();
        }
        throw new EntityNotFoundException("El rol no se encuentra registrado");*/

        if (!rol.isPresent()) {
            throw new EntityNotFoundException("El rol no se encuentra registrado");
        }
        if (!rol.get().getPersons().isEmpty()) {
            throw new EntityNotFoundException("El rol se encuentra asociado a un usuario");
        }

        //roleRepository.delete(rol.get());
        roleRepository.deleteById(id);
        return rol.get();
    }

    @Override
    public List<Rol> finAllRolesByFilter(String filter, String value) {
        return roleRepository.findAll();
    }

    @Override
    public Rol createNewRole(String name) {
        Rol newrol= new Rol();
        newrol.setName(name);
        if (getRolByName(name).isPresent()) {
            throw new RolDuplicateException("El rol " + name + " ya esta registrado",
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return roleRepository.save(newrol);
    }

    private Optional<Rol> getRolByName(String rolname){
        return roleRepository.findByName(rolname);
    }

    @Override
    public List<Rol> findAllRolesByFilter(String filter, String value) {
        return roleRepository.findAll();
    }

    @Override
    public Rol createNewRol(String name){
        Rol newRol = new Rol();
        newRol.setName(name);

        if(getRolByName(name).isPresent()){
            throw new RolDuplicateException("El Rol " +name+ " ya está registrado", 
            HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return roleRepository.save(newRol);
    }

    //put
    @Override
    public Rol updateRol(Long id, String name){
        Optional<Rol> findRol = roleRepository.findById(id);

        if (findRol.isPresent()) {
            Rol existRol = findRol.get();
            existRol.setName(name);

            return roleRepository.save(existRol);
        }
        else{
            throw new RuntimeException("El rol con id" + id + " no existe");
        }
    }

    //delete
    @Override
    public void deleteRol(Long id){
        if(roleRepository.existsById(id)){
            roleRepository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol con id " + id + " no existe");
        }
    }

}
