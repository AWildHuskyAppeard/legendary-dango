package cart;

public interface CartDAO {
	// 建立連線、提供SQL方法
	
	boolean insertOrder(OrderBean orderBean);
	boolean selectOrder(OrderBean orderBean);
	// 回傳資料筆數；0表示沒變化、-1表示出問題
	int updateOrder(OrderBean orderBean); 
//	int deleteOrder(OrderBean orderBean); // cart大概無法刪資料
	
}
