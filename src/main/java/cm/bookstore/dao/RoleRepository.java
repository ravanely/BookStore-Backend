package cm.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.bookstore.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
