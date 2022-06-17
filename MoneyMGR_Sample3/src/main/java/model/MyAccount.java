package model;

//直列化
import java.io.Serializable;

public class MyAccount implements Serializable {
	  private String m_accName; //ニックネーム
	  private String m_accID; //アカウントID
	  private String m_password; //パスワード
	  private int m_debt; //借金額
	  private int m_credit; //貸金額
	  //private int  m_balance; //残高

	  //コンストラクタ定義
	  public MyAccount(){ //デフォルトコンストラクタのため中身なし
	  }
	  
	 
	  public MyAccount(String accID, String pass) {//ログイン時に照合する情報
		  this.m_accID = accID;
		  this.m_password = pass;
	  }
	  public MyAccount(String accID, String name, String pass) {//ログイン時に照合する情報
		  this.m_accID = accID;
		  this.m_accName = name;
		  this.m_password = pass;
		  
	  }
	  

	  //getterメソッドを定義
	  public String getAccName(){
	    return this.m_accName;
	  }
	  public String getAccID(){
	    return this.m_accID;
	  }
	  public String getPass(){
	    return this.m_password;
	  }
	  public int getDebt(){
	    return this.m_debt;
	  }
	  public int getCredit(){
	    return this.m_credit;
	  }
	  /*public int getBalance(){
	    return this.m_balance;
	  }*/

	  //setterメソッドを定義
	  public void setAccName(String accname){
	    this.m_accName = accname;
	  }
	  public void setAccID(String accid){
	    this.m_accID = accid;
	  }
	  public void setPass(String pass){
	    this.m_password = pass;
	  }
	  public void setDebt(int debt){
	    this.m_debt = debt;
	  }
	  public void setCredit(int credit){
	    this.m_credit = credit;
	  }
	  /*public void setBalance(int balance){
	    this.m_balance = balance;
	  }*/

}
