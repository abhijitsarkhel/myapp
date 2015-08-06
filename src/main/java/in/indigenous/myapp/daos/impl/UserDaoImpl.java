package in.indigenous.myapp.daos.impl;

import org.springframework.stereotype.Service;

import com.googlecode.objectify.ObjectifyService;

import in.indigenous.myapp.daos.UserDao;
import in.indigenous.myapp.model.User;

@Service("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public User getUserByEmail(String email) {
		return ObjectifyService.ofy().load().type(User.class).id(email).now();
	}

	@Override
	public boolean save(User user) {
		ObjectifyService.ofy().save().entity(user).now();
		return true;
	}

}
