package zw.co.equals.customersupportservice.exception;

public class ApiReadTimeOutException extends RuntimeException{
    public ApiReadTimeOutException(String message) {
        super(message);
    }
}
