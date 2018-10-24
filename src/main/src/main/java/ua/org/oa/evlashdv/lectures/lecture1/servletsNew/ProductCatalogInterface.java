package ua.org.oa.evlashdv.lectures.lecture1.servletsNew;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;

public interface ProductCatalogInterface {

	List<String> getProductCategories();
	@WebMethod(exclude=true)
	List<String> getProducts(String category);
	@WebMethod(exclude=true)
	boolean addProducts(String category, String product);
	@WebMethod
	@WebResult(name="Product")
	List<Product> getProductsv2(String category);

}