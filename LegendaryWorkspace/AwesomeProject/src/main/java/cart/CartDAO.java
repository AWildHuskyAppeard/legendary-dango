package cart;

public interface CartDAO {
	// 建立連線、提供SQL方法
	
	int insertOrder(OrderBean orderBean);
	boolean selectOrder(OrderBean orderBean);
	// 回傳資料筆數；0表示沒變化、-1表示出問題、1以上表示更改比數
	int updateOrder(OrderBean orderBean, Object obj3, Object obj4); 
	
	// order只會修正資料，紀錄會一直留下
//	int deleteOrder(OrderBean orderBean); 
	
}
