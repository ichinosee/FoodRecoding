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
import la.bean.CustomerBean;
import la.dao.DAOException;
import la.dao.RecordDAO;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//記録処理の業務はすべてセッションとCartが存在することが前提
		HttpSession session = request.getSession(false);
		if (session == null) {//セッションオブジェクトなし
			request.setAttribute("message", "セッションが切れています。もう一度トップページより操作してください");
			gotoPage(request, response, "/errInternal.jsp");
			return;
		}
		CartBean cart = (CartBean) session.getAttribute("cart");
		if (cart == null) {//カートがない
			request.setAttribute("message", "正しく操作してください");
			gotoPage(request, response, "/errInternal.jsp");
			return;
		}

		try {
			//パラメーターの解析
			String action = request.getParameter("action");
			//input_customerまたはパラメーターなしの場合はユーザー情報入力ページを表示
			if (action == null || action.length() == 0 || action.equals("input_customer")) {
				gotoPage(request, response, "/customerInfo.jsp");
				//confirmhaは確認処理を行う
			} else if (action.equals("confirm")) {
				CustomerBean bean = new CustomerBean();
				bean.setName(request.getParameter("name"));
				bean.setAddress(request.getParameter("address"));
				bean.setTel(request.getParameter("tel"));
				bean.setEmail(request.getParameter("email"));
				session.setAttribute("customer", bean);
				gotoPage(request, response, "/confirm.jsp");
				//orderは記録確定
			} else if (action.equals("regist")) {
				CustomerBean customer = (CustomerBean) session.getAttribute("customer");
				if (customer == null) {
					//ユーザー情報がない
					request.setAttribute("message", "正しく操作してください");
					gotoPage(request, response, "/errInternal.jsp");
				}

				RecordDAO order = new RecordDAO();
				int orderNumber = order.saveOrder(customer, cart);
				//記録はセッション情報をクリアする
				session.removeAttribute("cart");
				session.removeAttribute("customer");
				//記録番号をクライアントへ送る
				request.setAttribute("orderNumber", Integer.valueOf(orderNumber));
				gotoPage(request, response, "/regist.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
