package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FriendAccount;
import model.MyAccount;
/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    // 友達の一覧をアプリケーションスコープから取得
	    ServletContext application = this.getServletContext();
	    List<FriendAccount> friendList =
	        (List<FriendAccount>) application.getAttribute("friendList");
	    // 取得できなかった場合は、つぶやきリストを新規作成して
	    // アプリケーションスコープに保存
	    if (friendList == null) {
	    	friendList = new ArrayList<FriendAccount>();
	      application.setAttribute("friendList", friendList);
	    }
	    // ログインしているか確認するため
	    // セッションスコープからユーザー情報を取得
	    HttpSession session = request.getSession();
	    MyAccount loginUser = (MyAccount) session.getAttribute("loginUser");
	    if (loginUser == null) { // ログインしていない場合
	    // リダイレクト
	      response.sendRedirect("/MoneyMGR_Sample3/");
	    } else { // ログイン済みの場合
	    // フォワード
	      RequestDispatcher dispatcher =
	          request.getRequestDispatcher("/WEB-INF/jsp/MyPage.jsp");
	      dispatcher.forward(request, response);
	    }		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	  protected void doPost(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
			/*pleaseDeleteFrom
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String creditValue = request.getParameter("creditV");
	    String debtValue = request.getParameter("debtV");
	    int credit =  Integer.parseInt(creditValue);
	    int debt =  Integer.parseInt(debtValue);

	    // 入力値チェック
	    if (credit != 0 ) {
	      // アプリケーションスコープに保存された友達リストを取得
	      ServletContext application = this.getServletContext();
	      List<FriendAccount> friendList =
	          (List<FriendAccount>) application.getAttribute("friendList");


	      // セッションスコープに保存されたユーザー情報を取得
	      HttpSession session = request.getSession();
	      MyAccount loginUser = (MyAccount) session.getAttribute("loginUser");

	      // 友達リストに追加
	      FriendAccount friend = new FriendAccount(loginUser.getAccName(), credit, debt);
	      PostFriendLogic postFriendLogic = new PostFriendLogic();
	      postFriendLogic.execute(friend, friendList);
	      

	      // アプリケーションスコープに友達リストを保存
	      application.setAttribute("friendList", friendList);
	    } else {
	      //エラーメッセージをリクエストスコープに保存
	      request.setAttribute("errorMsg", "内容を確認してください");
	    }
	    	         */ //pleaseDeleteEnd

	    // メイン画面にフォワード

	    RequestDispatcher dispatcher =
	        request.getRequestDispatcher("/WEB-INF/jsp/MyPage.jsp");

	    dispatcher.forward(request, response);
	  }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	*/

}
