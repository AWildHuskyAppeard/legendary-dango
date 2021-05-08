package chat;

import java.util.ArrayList;

public interface ChatDAO {
	
	boolean insertChat(ChatVO chat);
	
    boolean deleteChat(Integer C_ID);
	
	boolean updateChat(ChatVO chat);
	
	ArrayList<ChatVO> findAllChat();

}
