package edu.rosehulman.covidtracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
