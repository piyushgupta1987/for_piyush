package service;

public class ProductServiceException extends Exception {

	public ProductServiceException() {
		super();
	}

	public ProductServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductServiceException(String message) {
		super(message);
	}

	public ProductServiceException(Throwable cause) {
		super(cause);
	}
	

}
