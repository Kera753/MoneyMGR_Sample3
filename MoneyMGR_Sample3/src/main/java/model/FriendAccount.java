package model;
//書き込みまだ
import java.io.Serializable;

public class FriendAccount implements Serializable {
	  private String userName; // ユーザー名
	  private int credit;
	  private int debt;
	  
	  private String text;

	  public FriendAccount() {
	  }

	  public FriendAccount(String userName, int credit, int debt) {
	    this.userName = userName;
	    this.credit = credit;
	    this.debt = debt;
	  }
	  
	  public FriendAccount(String userName, String text) {
		    this.userName = userName;
		    this.text = text;
	  }

	  public String getUserName() {
	    return userName;
	  }
	  
	  public int getCredit() {
		    return credit;
		  }
	  
	  public String getText() {
		    return text;
		  }

	  public int getDebt() {
	    return debt;
	  }
}
