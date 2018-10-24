package ua.org.oa.evlashdv.lectures.lecture1.servletsNew;

public class InvalidInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 156224021812477531L;
	private String errorDetails;
	public InvalidInputException(String reason,String errorDetails) {
		super(reason);
		this.errorDetails=errorDetails;
	
	}
	public String getFaultInfo() {
		return errorDetails;
	}
}
