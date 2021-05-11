package chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChatDAOImpl implements ChatDAO{
	
private Connection conn;
	
	public ChatDAOImpl(Connection conn) {
		this.conn = conn;
		}

	@Override
	public boolean insertChat(ChatVO chat) {
		String sql="INSERT INTO [dbo].[Chat]\r\n"
				+ "           ([C_ID]\r\n"
				+ "           ,[C_Date]\r\n"
				+ "           ,[C_Class]\r\n"
				+ "           ,[C_Title]\r\n"
				+ "           ,[C_Conts]\r\n"			
				+ "           ,[U_ID])\r\n"
				+ "     VALUES\r\n"
				+ "           (?,?,?,?,?,?)";
		boolean isInsert=false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, "(SELECT MAX([C_ID])+1 FROM [dbo].[Chat])");				
			stmt.setString(2, chat.getC_Date());
			stmt.setString(3, chat.getC_Class());
			stmt.setString(4, chat.getC_Title());
			stmt.setString(5, chat.getC_Conts());
			stmt.setString(6, chat.getU_ID());
			int i=stmt.executeUpdate();
			if(i>0) {
				isInsert=true;
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isInsert;
	}

	@Override
	public boolean deleteChat(ChatVO chat) {
		String sql="DELETE FROM [dbo].[Chat]\r\n"
				+ "      WHERE [C_ID] = ?";
		boolean isDelete=false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, chat.getC_ID());
			int i=stmt.executeUpdate();
			if(i>0) {
				isDelete=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDelete;
	}

	@Override
	public boolean updateChat(ChatVO chat) {
		String sql="UPDATE [dbo].[Chat]\r\n"
				+ "   SET [C_Date] = ?\r\n"
				+ "      ,[C_Class] = ?\r\n"
				+ "      ,[C_Title] = ?\r\n"
				+ "      ,[C_Conts] = ?\r\n"
				+ " WHERE [C_ID] = ?";
		boolean isUpdate=false;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(5, chat.getC_ID());
			stmt.setString(1, chat.getC_Date());
			stmt.setString(2, chat.getC_Class());
			stmt.setString(3, chat.getC_Title());
			stmt.setString(4, chat.getC_Conts());
			int i=stmt.executeUpdate();
			if(i>0) {
				isUpdate=true;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdate;
	}

	@Override
	public ArrayList<ChatVO> findAllChat() {
		ArrayList<ChatVO> chat = new ArrayList<>();
		String sql = " select [C_Class]\r\n"
				+ "      ,[C_Title]\r\n"
				+ "      ,[C_Date]\r\n"
				+ " from [dbo].[Chat]";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ChatVO chatvo = new ChatVO();
				chatvo.setC_Class(rs.getString("C_Class"));
				chatvo.setC_Title(rs.getString("C_Title"));
				chatvo.setC_Date(rs.getString("C_Date"));
				
				chat.add(chatvo);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return chat;
	}

}
