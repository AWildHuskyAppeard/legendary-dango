package chat;

import java.util.ArrayList;

public interface ChatDAO {
	
	boolean insertChat(ChatVO chat);
	
    boolean deleteChat(ChatVO chat);
	
	boolean updateChat(ChatVO chat);
	
	ArrayList<ChatVO> findAllChat();

}
