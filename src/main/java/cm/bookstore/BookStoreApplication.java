package cm.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cm.bookstore.config.SecurityUtility;
import cm.bookstore.entities.User;
import cm.bookstore.security.Role;
import cm.bookstore.security.UserRole;
import cm.bookstore.service.UserService;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setFirstName("Fab");
		user.setLastName("Ravanely");
		user.setUsername("frav");
		user.setPassword(SecurityUtility.passwordEncoder().encode("user"));
		user.setEmail("fab@gmail.com");
		
		Set<UserRole> userRoles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		userRoles.add(new UserRole(user, role));
		userService.createUser(user, userRoles);
		
		userRoles.clear();
		
		User user2 = new User();
		user.setFirstName("Admin");
		user.setLastName("Admin");
		user.setUsername("admin");
		user.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user.setEmail("admin@gmail.com");
		
		Set<UserRole> userRoles2 = new HashSet<>();
		Role role2 = new Role();
		role2.setRoleId(2);
		role2.setName("ROLE_ADMIN");
		userRoles2.add(new UserRole(user2, role2));
		
		userService.createUser(user2, userRoles2);
	}
}
