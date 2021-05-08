package cart;
// Cart = ArrayList<ProductBean> = ArrayList<CartItem>
// OrderBean = cart +- 一些額外資訊
public class OrderBean {
	private String O_ID ; // PK
	private String P_ID; // FK
	private String P_Name; // FK
	private Integer P_Price; // FK
	private String U_ID; // FK
	private String U_FirstName; // FK
	private String U_LastName; // FK
	private String U_Email; // FK
	private String O_Status;
	private String O_Date; // Date()會不會更好？
	private Integer O_Amt;
	// constructors
	public OrderBean() {};
	public OrderBean(String o_ID, String p_ID, String p_Name, Integer p_Price, String u_ID, String u_FirstName,
			String u_LastName, String u_Email, String o_Status, String o_Date, Integer o_Amt) {
		super();
		setO_ID         (o_ID       );
		setP_ID         (p_ID       );
		setP_Name       (p_Name     );
		setP_Price      (p_Price    );
		setU_ID         (u_ID       );
		setU_FirstName  (u_FirstName);
		setU_LastName   (u_LastName );
		setU_Email      (u_Email    );
		setO_Status     (o_Status   );
		setO_Date       (o_Date     );
		setO_Amt        (o_Amt      );
	}                    
	// getters
	public String getO_ID() {return O_ID;}
	public String getP_ID() {return P_ID;}
	public String getP_Name() {return P_Name;}
	public Integer getP_Price() {return P_Price;}
	public String getU_ID() {return U_ID;}
	public String getU_FirstName() {return U_FirstName;}
	public String getU_LastName() {return U_LastName;}
	public String getU_Email() {return U_Email;}
	public String getO_Status() {return O_Status;}
	public String getO_Date() {return O_Date;}
	public Integer getO_Amt() {return O_Amt;}
	// setters
	public void setO_ID(String o_ID) {	O_ID = o_ID;}
	public void setP_ID(String p_ID) {P_ID = p_ID;}
	public void setP_Name(String p_Name) {P_Name = p_Name;}
	public void setP_Price(Integer p_Price) {P_Price = p_Price;}
	public void setU_ID(String u_ID) {U_ID = u_ID;}
	public void setU_FirstName(String u_FirstName) {U_FirstName = u_FirstName;}
	public void setU_LastName(String u_LastName) {U_LastName = u_LastName;}
	public void setU_Email(String u_Email) {U_Email = u_Email;}
	public void setO_Status(String o_Status) {O_Status = o_Status;}
	public void setO_Date(String o_Date) {O_Date = o_Date;}
	public void setO_Amt(Integer o_Amt) {O_Amt = o_Amt;}
	
	// ˊ<_ˋ
	public String get(int index) {
		switch (index) {
		case 1:
			return getO_ID();
			break;
		case 2:
			return getP_ID();
			break;
		case 3:
			return getP_Name();
			break;
		case 4:
			return String.valueOf(getP_Price());
			break;
		case 5:
			return getU_ID();
			break;
		case :
			return;
			break;
		case :
			return;
			break;
		case :
			return;
			break;
		case :
			return;
			break;
		case :
			return;
			break;
		case :
			return;
			break;

		default:
			break;
		}
		getO_ID();
	}
	
}
/* Database table
	訂單編號	O_ID	int
	課程編號	P_ID	nvarchar(20)
	課程名稱	P_Name	nvarchar(20)
	課程價格	P_Price	int
	會員帳號	U_ID	nvarchar(20)
	會員名	U_FirstName	nvarchar(20)
	會員姓	U_LastName	nvarchar(20)
	會員信箱	U_Email	nvarchar(max)
	訂單狀態	O_Status	nvarchar(max)
	訂單日期	O_Date	smalldatetime
	訂單總額	O_Amt	int
*/