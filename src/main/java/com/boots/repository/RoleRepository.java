package com.boots.repository;

import com.boots.domain.ERole;
import com.boots.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//public interface RoleRepository extends JpaRepository<Role, Long> {
//}

public interface RoleRepository extends MongoRepository<Role, Long> {
//    Role findByRoleName(String roleName); //Щойно створив методу не було
    Optional<Role> findByName(ERole name);
}
