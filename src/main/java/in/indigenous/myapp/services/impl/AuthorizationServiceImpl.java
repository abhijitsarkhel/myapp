package in.indigenous.myapp.services.impl;

import in.indigenous.myapp.daos.UserDao;
import in.indigenous.myapp.model.UserAuthority;
import in.indigenous.myapp.services.AuthorizationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthorizationServiceImpl implements UserDetailsService,
		AuthorizationService {

	private static final String SPACE = " ";

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		List<UserAuthority> userAuthorities = userDao
				.getUserAuthority(userName);
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (UserAuthority userAuthority : userAuthorities) {
			authorities.add(new SimpleGrantedAuthority(userAuthority
					.getAuthority()));
		}
		in.indigenous.myapp.model.User user = userDao.getUserByEmail(userName);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		UserDetails details = new User(new StringBuilder(user.getFirstName())
				.append(SPACE).append(user.getLastName()).toString(),
				user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		return details;
	}

}
