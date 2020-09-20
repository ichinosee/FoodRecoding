package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import la.bean.CartBean;
import la.bean.CustomerBean;
import la.bean.FoodBean;

public class RecordDAO {
	private Connection con;

	public RecordDAO() throws DAOException{
		getConnection();
	}

	public int saveOrder(CustomerBean customer, CartBean cart)
	throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//顧客情報の取得Serial型の暗黙シーケンスから取得
			int customerNumber = 0;
			String sql = "SELECT nextval('customer_code_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
				customerNumber = rs.getInt(1);
			}
			rs.close();
			st.close();
			//顧客情報の追加SQL文
			sql = "INSERT INTO customer VALUES(?, ?, ?, ?, ?)";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//プレースホルダーの設定
			st.setInt(1, customerNumber);
			st.setString(2, customer.getName());
			st.setString(3, customer.getAddress());
			st.setString(4, customer.getTel());
			st.setString(5, customer.getEmail());
			//SQLの実行
			st.executeUpdate();
			st.close();
			//注文番号の取得Serial型の暗黙シーケンスからの取得
			int orderNumber = 0;
			sql = "SELECT nextval('ordered_code_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
				orderNumber = rs.getInt(1);
			}
			rs.close();
			st.close();

			//注文情報のOrderedテーブルへの追加
			sql = "INSERT INTO ordered VALUES(?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			//プレースホルダーの設定
			st.setInt(1, orderNumber);
			st.setInt(2, customerNumber);
			Date today = new Date(System.currentTimeMillis());
			st.setDate(3, today);
		    st.setInt(4, cart.getTotal());
		    //SQLの実行
		    st.executeUpdate();
		    st.close();

		    //注文明細情報のOrderDetailテーブルへの追加
		    //商品ごとに風数レコード追加
		    sql = "INSERT INTO ordered_detail VALUES(?, ?, ?)";
		    st = con.prepareStatement(sql);
		    Map<Integer, FoodBean> items = cart.getItems();
		    Collection<FoodBean> list = items.values();
		    for(FoodBean food : list) {
		    	st.setInt(1, orderNumber);
		    	st.setInt(2, food.getCode());
		    	st.setInt(3, food.getQuantity());
		    	st.executeUpdate();
		    }
		    st.close();
		    return orderNumber;
		    }catch(Exception e){
		    	e.printStackTrace();
		    	throw new DAOException("レコードの操作に失敗しました");

}finally
	{
		try {
			//リソースの開放
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			close();
		} catch (Exception e) {
			throw new DAOException("リソースの開放に失敗しました");
		}
	}
}

	private void getConnection() throws DAOException {
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//URL、ユーザー名、パスワードの設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";
			//データベースの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new DAOException("接続に失敗しました");
		}
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

}
