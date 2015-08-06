package in.indigenous.myapp.services;

import in.indigenous.myapp.forms.beans.LoginFormBean;
import in.indigenous.myapp.forms.beans.RegistrationFormBean;

public interface UserService {

	public boolean register(RegistrationFormBean user);

	public boolean login(LoginFormBean user);
}
