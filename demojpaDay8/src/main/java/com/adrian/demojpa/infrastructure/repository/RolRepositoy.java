package com.adrian.demojpa.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.demojpa.domain.Rol;

//Esa línea define un repositorio en Spring Data JPA, y lo que estás escribiendo
// es una interfaz que hereda de JpaRepository. Su propósito es permitirte acceder
// y manipular la base de datos de forma sencilla, sin tener que escribir SQL.

public interface RolRepositoy extends JpaRepository<Rol, Long>{

}
