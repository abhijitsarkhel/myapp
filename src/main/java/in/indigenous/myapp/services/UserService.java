package in.indigenous.myapp.services;

import in.indigenous.myapp.model.User;

public interface UserService {

	public boolean register(User user);

	public boolean login(User user);
}
