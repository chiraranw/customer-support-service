package zw.co.equals.customersupportservice.exception;

public class ApiConnectionTimeOutException extends RuntimeException{
    public ApiConnectionTimeOutException(String message) {
        super(message);
    }
}