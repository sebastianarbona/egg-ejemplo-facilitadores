package com.egg.facilitadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.facilitadores.entidades.Alumno;

@Repository("alumnoRepository")
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{

}
