package in.indigenous.myapp.daos.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.googlecode.objectify.ObjectifyService;

import in.indigenous.myapp.daos.UserDao;
import in.indigenous.myapp.model.User;
import in.indigenous.myapp.model.UserAuthority;

@Service("userDao")
public class UserDaoImpl implements UserDao {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserDaoImpl.class);

	@Override
	public User getUserByEmail(String email) {
		LOGGER.info("Inside getUserByEmail method.");
		return ObjectifyService.ofy().load().type(User.class).id(email).now();
	}

	@Override
	public boolean save(User user) {
		LOGGER.info("Inside save method.");
		ObjectifyService.ofy().save().entity(user).now();
		return true;
	}

	public boolean addUserAuthority(UserAuthority userAuthority) {
		LOGGER.info("Inside addUserAuthority method.");
		ObjectifyService.ofy().save().entity(userAuthority).now();
		return true;
	}

	@Override
	public List<UserAuthority> getUserAuthority(String email) {
		LOGGER.info("Inside getUserAuthority method");
		return ObjectifyService.ofy().load().type(UserAuthority.class)
				.filter("email ==", email).list();
	}
}
