package qadoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import qadoc.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}