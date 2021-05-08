package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO{
	
	private Connection conn;
	
	public ProductDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	
	

	@Override
	public ProductBean findProductByProductNo(String P_ID) {
		String sql = "select * from Product where P_ID =?";
		ProductBean pBean = new ProductBean();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
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
			stmt.close();
			rs.close();
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pBean;
	}

	@Override
	public ArrayList<ProductBean> findAll() {
		String sql = "select * from Product";
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ProductBean pBean = new ProductBean();
				pBean.setP_Class(rs.getString("P_Class"));
				pBean.setP_DESC(rs.getString("P_DESC"));
				pBean.setP_ID(rs.getString("P_ID"));
				pBean.setP_Img(rs.getString("P_Img"));
				pBean.setP_Name(rs.getString("P_Name"));
				pBean.setP_Price(rs.getInt("P_Price"));
				pBean.setP_Video(rs.getString("P_Video"));
				pBean.setU_ID(rs.getString("U_ID"));
				list.add(pBean);
			}
			stmt.close();
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean insertProduct(ProductBean Product) {
		String sql = "\r\n"
				+ "INSERT INTO [dbo].[Product]\r\n"
				+ "           ([P_ID]\r\n"
				+ "           ,[P_Name]\r\n"
				+ "           ,[P_Class]\r\n"
				+ "           ,[P_Price]\r\n"
				+ "           ,[P_DESC]\r\n"
				+ "           ,[P_Img]\r\n"
				+ "           ,[P_Video]\r\n"
				+ "           ,[U_ID])\r\n"
				+ "     VALUES (?,?,?,?,?,?,?,?)";
		boolean isInsert = false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Product.getP_ID());
			stmt.setString(2, Product.getP_Name());
			stmt.setString(3, Product.getP_Class());
			stmt.setInt(4, Product.getP_Price());
			stmt.setString(5, Product.getP_DESC());
			stmt.setString(6, Product.getP_Img());
			stmt.setString(7, Product.getP_Video());
			stmt.setString(8, Product.getU_ID());
			int i = stmt.executeUpdate();
			if (i>0) {
				isInsert=true;
			}
			stmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isInsert;
	}

	@Override
	public boolean updateProduct(ProductBean Product) {
		String sql = "UPDATE [dbo].[Product]\r\n"
				+ "   SET [P_Name] = ?\r\n"
				+ "      ,[P_Class] = ?\r\n"
				+ "      ,[P_Price] = ?\r\n"
				+ "      ,[P_DESC] = ?\r\n"
				+ "      ,[P_Img] = ?\r\n"
				+ "      ,[P_Video] = ?\r\n"
				+ " WHERE [P_ID] = ?";
		boolean isUpdate = false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Product.getP_ID());
			stmt.setString(2, Product.getP_Name());
			stmt.setString(3, Product.getP_Class());
			stmt.setInt(4, Product.getP_Price());
			stmt.setString(5, Product.getP_DESC());
			stmt.setString(6, Product.getP_Img());
			stmt.setString(7, Product.getP_Video());
			stmt.setString(8, Product.getU_ID());
			int i = stmt.executeUpdate();
			if (i>0) {
				isUpdate=true;
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdate;
	}

	@Override
	public boolean deleteProduct(String P_ID) {
		String sql = "DELETE FROM [dbo].[Product]\r\n"
				+ "      WHERE [P_ID] = ?";
		boolean isDelete = false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, P_ID);
			int i = stmt.executeUpdate();
			if (i>0) {
				isDelete = true;
			}
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDelete;
	}
	

	
	

}
