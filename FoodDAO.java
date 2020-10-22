package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.CategoryBean;
import la.bean.FoodBean;

public class FoodDAO {
	private Connection con;

	public FoodDAO() throws DAOException {
		getConnection();
	}

	public List<CategoryBean> findAllCategory() throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "SELECT * FROM category ORDER BY code";
			//prepareStatementオブジェクトの習得
			st = con.prepareStatement(sql);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得及び表示
			List<CategoryBean> list = new ArrayList<CategoryBean>();
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				CategoryBean bean = new CategoryBean(code, name);
				list.add(bean);
			}
			//情報一覧をlistとして返す
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
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

	public List<FoodBean> findByCategory(int categoryCode)

			throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "SELECT * FROM food WHERE category_code = ? ORDER BY code";
			//prepareStatementオブジェクトの習得
			st = con.prepareStatement(sql);
			//カテゴリの設定
			st.setInt(1, categoryCode);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得及び表示
			List<FoodBean> list = new ArrayList<FoodBean>();
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int calorie = rs.getInt("calorie");
				FoodBean bean = new FoodBean(code, name, calorie);
				list.add(bean);
			}
			//情報一覧をlistとして返す
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
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

	public FoodBean findByPrimaykey(int key) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "SELECT * FROM food WHERE code = ?";
			//prepareStatementオブジェクトの習得
			st = con.prepareStatement(sql);
			//主キーの設定
			st.setInt(1, key);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得及び表示

			if (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int calorie = rs.getInt("calorie");
				FoodBean bean = new FoodBean(code, name, calorie);
				return bean;
			} else {
				//主キーに該当するレコードなし
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} finally {
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
			//JDBCドライバの登録
			String url = "jdbc:postgresql:sample";
			String user = "hogehoge";
			String pass = "hogehoge";
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
