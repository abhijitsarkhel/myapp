package in.indigenous.myapp.services.impl;

import in.indigenous.myapp.daos.UserDao;
import in.indigenous.myapp.forms.beans.LoginFormBean;
import in.indigenous.myapp.forms.beans.RegistrationFormBean;
import in.indigenous.myapp.model.User;
import in.indigenous.myapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean register(RegistrationFormBean user) {
		User entity = new User();
		entity.setEmail(user.getEmail());
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setPassword(user.getPassword());
		userDao.save(entity);
		return true;
	}

	@Override
	public boolean login(LoginFormBean user) {
		User found = userDao.getUserByEmail(user.getEmail());
		if (found != null && found.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
