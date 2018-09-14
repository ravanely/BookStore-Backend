package cm.bookstore.service;

import java.util.Set;

import cm.bookstore.entities.User;
import cm.bookstore.security.UserRole;

public interface UserService {

	User createUser(User user, Set<UserRole> userRoles);
}
