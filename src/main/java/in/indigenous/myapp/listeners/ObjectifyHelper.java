package in.indigenous.myapp.listeners;

import in.indigenous.myapp.model.User;
import in.indigenous.myapp.model.UserAuthority;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;

public class ObjectifyHelper implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// We do not use this method.
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ObjectifyService.register(User.class);
		ObjectifyService.register(UserAuthority.class);
	}

}
