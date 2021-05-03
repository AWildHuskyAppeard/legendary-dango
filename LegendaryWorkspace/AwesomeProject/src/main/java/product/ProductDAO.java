package learningWeb;

import java.util.ArrayList;

public interface ProductDAO {
	
	//find class by class id
	ProductBean findProductByProductNo(String P_ID);
	//find all classes
	ArrayList<ProductBean>findAllProduct();
	//insert class
	boolean insertProduct(ProductBean Product);
	//update class
	boolean updateProduct(ProductBean Product);
	//delete class
	boolean deleteProduct(String P_ID);

}
