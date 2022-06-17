package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.MyAccount;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
	    String accID = request.getParameter("accID");
	    String pass = request.getParameter("pass");

	    // MyAccountインスタンス（ユーザー情報）の生成
	    MyAccount m_user = new MyAccount(accID, pass);

	    // ログイン処理
	    LoginLogic loginLogic = new LoginLogic();
	    boolean isLogin = loginLogic.execute(m_user);
	    
	    //ログイン成功時
	    if (isLogin) {
	        // ユーザー情報をセッションスコープに保存
	        HttpSession session = request.getSession();
	        session.setAttribute("loginUser", m_user);
	      }
	      // ログイン結果画面にフォワード
	      RequestDispatcher dispatcher =
	          request.getRequestDispatcher
	              ("/WEB-INF/jsp/loginResult.jsp");
	      dispatcher.forward(request, response);

		
		doGet(request, response);
		
	}

}
