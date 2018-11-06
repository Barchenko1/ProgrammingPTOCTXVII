package ua.org.oa.evlashdv.lectures.lecture1.servletsNew;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public class ShopInfo {
	@WebMethod
	@WebResult(partName="lookuoOutout")
	public String getShopInfo(@WebParam(partName="lookupInput")String property) throws InvalidInputException {
		String responce="Invalid property";
		if("shopName".equals(property)) {
			responce="Test Mark";
		}else if ("since".equals(property)) {
			responce="since 2012";
		}else {
			throw new InvalidInputException("Invalid Input",property+" is not a valid input");
		}
		return responce;
	}
}
