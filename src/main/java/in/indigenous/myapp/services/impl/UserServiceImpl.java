package in.indigenous.myapp.services.impl;

import in.indigenous.myapp.model.User;
import in.indigenous.myapp.services.UserService;

import com.googlecode.objectify.ObjectifyService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean register(User user) {
		ObjectifyService.ofy().save().entity(user).now();
		return true;
	}

	@Override
	public boolean login(User user) {
		User found = ObjectifyService.ofy().load().type(User.class).id(user.getEmail()).now();
		if(found != null && found.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}

}
