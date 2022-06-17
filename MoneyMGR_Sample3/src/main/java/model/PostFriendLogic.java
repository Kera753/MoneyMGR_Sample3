package model;
import java.util.List;

public class PostFriendLogic {
	  public void execute(FriendAccount friend, List<FriendAccount> friendList) {
		    friendList.add(0, friend); // 先頭に追加 解説①
		  }

}
