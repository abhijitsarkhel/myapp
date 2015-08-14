package in.indigenous.myapp.services.impl;

import in.indigenous.myapp.daos.UserDao;
import in.indigenous.myapp.forms.beans.LoginFormBean;
import in.indigenous.myapp.forms.beans.RegistrationFormBean;
import in.indigenous.myapp.model.User;
import in.indigenous.myapp.model.UserAuthority;
import in.indigenous.myapp.model.UserRoles;
import in.indigenous.myapp.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Override
	public boolean register(RegistrationFormBean user) {
		LOGGER.info("Inside register method");
		User entity = new User();
		entity.setEmail(user.getEmail());
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(entity);
		UserAuthority userAuthority = new UserAuthority();
		userAuthority.setEmail(user.getEmail());
		userAuthority.setAuthority(UserRoles.ROLE_USER.toString());
		userDao.addUserAuthority(userAuthority);
		return true;
	}

	@Override
	public boolean login(LoginFormBean user) {
		LOGGER.info("Inside login method");
		User found = userDao.getUserByEmail(user.getEmail());
		if (found == null) {
			LOGGER.warn("User not found with email " + user.getEmail());
			return false;
		} else if (!passwordEncoder.matches(user.getPassword(), found.getPassword())) {
			LOGGER.warn("Wrong password for user " + user.getEmail());
			return false;
		}
		return true;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
