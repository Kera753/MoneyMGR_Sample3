package model;

public class LoginLogic {
	  public boolean execute(MyAccount m_user) {
		    if (m_user.getPass().equals("g20900")) {
		      return true;
		    }
		    return false;
		  }
}
