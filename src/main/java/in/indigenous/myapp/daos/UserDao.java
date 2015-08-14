package in.indigenous.myapp.daos;

import java.util.List;

import in.indigenous.myapp.model.User;
import in.indigenous.myapp.model.UserAuthority;

public interface UserDao {

	User getUserByEmail(String email);

	boolean save(User user);

	boolean addUserAuthority(UserAuthority userAuthority);

	List<UserAuthority> getUserAuthority(String email);
}
