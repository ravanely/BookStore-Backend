package cm.bookstore.serviceImpl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.bookstore.dao.RoleRepository;
import cm.bookstore.dao.UserRepository;
import cm.bookstore.entities.User;
import cm.bookstore.security.UserRole;
import cm.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
		}else {
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			localUser = userRepository.save(user);
		}
		return localUser;
	}

}
