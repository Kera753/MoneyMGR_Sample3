package model;
//書き込みまだ
import java.io.Serializable;

public class FriendAccount implements Serializable {
	  private String userName; // ユーザー名
	  private String text; 

	  public FriendAccount() {
	  }

	  public FriendAccount(String userName, String text) {
	    this.userName = userName;
	    this.text = text;
	  }

	  public String getUserName() {
	    return userName;
	  }

	  public String getText() {
	    return text;
	  }
}
