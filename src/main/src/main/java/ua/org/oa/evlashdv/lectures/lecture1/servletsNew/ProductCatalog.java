package ua.org.oa.evlashdv.lectures.lecture1.servletsNew;

import java.util.List;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebService;
@SOAPBinding(style= SOAPBinding.Style.RPC, use= SOAPBinding.Use.LITERAL)
@WebService(name="TestMartCatalog" ,endpointInterface="ProductCatalogInterface")
public class ProductCatalog implements ProductCatalogInterface {
	
	ProductServiceImpl productService=new ProductServiceImpl();
	
	/* (non-Javadoc)
	 * @see ua.mytest.barchenko.test.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories(){
		return productService.getProductCategories();
	}
	/* (non-Javadoc)
	 * @see ua.mytest.barchenko.test.ProductCatalogInterface#getProducts(java.lang.String)
	 */
	@Override
	public List<String> getProducts(String category){
		return productService.getProducts(category);
	}
	/* (non-Javadoc)
	 * @see ua.mytest.barchenko.test.ProductCatalogInterface#addProducts(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProducts(String category,String product){
		return productService.addProducts(category, product);
	}
	/* (non-Javadoc)
	 * @see ua.mytest.barchenko.test.ProductCatalogInterface#getProductsv2(java.lang.String)
	 */
	@Override
	public List<Product> getProductsv2(String category){
		return productService.getProductsv2(category);
	}
}
