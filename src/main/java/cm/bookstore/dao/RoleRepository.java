package cm.bookstore.dao;

import org.springframework.data.repository.CrudRepository;

import cm.bookstore.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
}
