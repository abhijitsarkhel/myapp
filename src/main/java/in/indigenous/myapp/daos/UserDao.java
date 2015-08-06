package in.indigenous.myapp.daos;

import in.indigenous.myapp.model.User;

public interface UserDao {

	User getUserByEmail(String email);

	boolean save(User user);
}
