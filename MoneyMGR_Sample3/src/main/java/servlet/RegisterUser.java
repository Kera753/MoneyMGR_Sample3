package servlet;

//登録
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MyAccount;
import model.RegisterUserLogic;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    // フォワード先
	    String forwardPath = null;

	    // サーブレットクラスの動作を決定する「action」の値を
	    // リクエストパラメータから取得
	    String action = request.getParameter("action");

	    // 「登録の開始」をリクエストされたときの処理
	    if (action == null) {
	      // フォワード先を設定
	      forwardPath = "/WEB-INF/jsp/registerForm.jsp";
	    }

	    // 登録確認画面から「登録実行」をリクエストされたときの処理
	    else if (action.equals("done")) {
	      // セッションスコープに保存された登録ユーザ
	      HttpSession session = request.getSession();
	      MyAccount registerUser = (MyAccount) session.getAttribute("registerUser");

	      // 登録処理の呼び出し
	      RegisterUserLogic logic = new RegisterUserLogic();
	      logic.execute(registerUser);

	      // 不要となったセッションスコープ内のインスタンスを削除
	      session.removeAttribute("registerUser");

	      // 登録後のフォワード先を設定
	      forwardPath = "/WEB-INF/jsp/registerDone.jsp";
	    } 

	    // 設定されたフォワード先にフォワード
	    RequestDispatcher dispatcher =
	        request.getRequestDispatcher(forwardPath);
	    dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	    RequestDispatcher toMyPageDispatcher = request.getRequestDispatcher(
	            "/WEB-INF/jsp/login.jsp");
	    toMyPageDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String id = request.getParameter("accID");
	    String name = request.getParameter("name");
	    String pass = request.getParameter("pass");

	    // 登録するユーザーの情報を設定
	    MyAccount registerUser = new MyAccount(id, pass, name);

	    // セッションスコープに登録ユーザーを保存
	    HttpSession session = request.getSession();
	    session.setAttribute("registerUser", registerUser);

	    // フォワード
	    RequestDispatcher dispatcher =
	        request.getRequestDispatcher
	            ("/WEB-INF/jsp/registerConfirm.jsp");
	    dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
