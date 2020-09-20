package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.CartBean;
import la.bean.FoodBean;
import la.dao.DAOException;
import la.dao.FoodDAO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//パラメーターの解析
			String action = request.getParameter("action");
			//showまたはパラメーターな しの場合はトップページを表示
			if (action == null || action.length() == 0 || action.equals("show")) {
				gotoPage(request, response, "/cart.jsp");
				//addはカートに追加処理
			} else if (action.equals("add")) {
				int code = Integer.parseInt(request.getParameter("food_code"));//注意
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				HttpSession session = request.getSession(true);
				CartBean cart = (CartBean) session.getAttribute("cart");
				if (cart == null) {
					//初めてのクライアントの場合はカートを作成する
					cart = new CartBean();
					session.setAttribute("cart", cart);
				}
				//商品コードの商品を取得する
				FoodDAO dao = new FoodDAO();
				FoodBean bean = dao.findByPrimaykey(code);
				//カートを追加する
				cart.addCart(bean, quantity);
				gotoPage(request, response, "/cart.jsp");
				//deleteはカートから削除処理
			} else if (action.equals("delete")) {
				HttpSession session = request.getSession(false);
				if (session == null) {
					request.setAttribute("message", "セッションが切れています。もう一度トップページより操作してください");
					gotoPage(request, response, "/errInternal.jsp");
					return;
				}
				CartBean cart = (CartBean) session.getAttribute("cart");
				if (cart == null) {
					request.setAttribute("message", "正しく操作してください");
					gotoPage(request, response, "/errInternal.jsp");
					return;
				}
				int code = Integer.parseInt(request.getParameter("food_code"));
				cart.deleteCart(code);
				gotoPage(request, response, "/cart.jsp");
			} else {
				//actionの値が不正
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/errInternal.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request, response, "/errInternal.jsp");
		}

	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
