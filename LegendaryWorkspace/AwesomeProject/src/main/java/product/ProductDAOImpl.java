package learningWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO{
	
	DataSource ds;

	@Override
	public ProductBean findProductByProductNo(String P_ID) {
		String sql = "select * from Product where P_ID =?";
		ProductBean pBean = new ProductBean();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/EmployeeDB");
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, P_ID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pBean.setP_Class(rs.getString("P_Class"));
				pBean.setP_DESC(rs.getString("P_DESC"));
				pBean.setP_ID(rs.getString("P_ID"));
				pBean.setP_Img(rs.getString("P_Img"));
				pBean.setP_Name(rs.getString("P_Name"));
				pBean.setP_Price(rs.getInt("P_Price"));
				pBean.setP_Video(rs.getString("P_Video"));
				pBean.setU_ID(rs.getString("U_ID"));
			}
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null)stmt.close();
				if(conn != null)conn.close();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return pBean;
	}

	@Override
	public ArrayList<ProductBean> findAllProduct() {
		
		return null;
	}

	@Override
	public boolean insertProduct(ProductBean Product) {
		
		return false;
	}

	@Override
	public boolean updateProduct(ProductBean Product) {
		
		return false;
	}

	@Override
	public boolean deleteProduct(String P_ID) {
		
		return false;
	}
	

	
	

}
