package Chapter2.com.exception;

/**
 * @author:xiehcao
 * @Date:2018/4/13
 * @Time:18:14
 * @description：
 */
public class InvaliPutException extends Throwable{
    private String message;

    public InvaliPutException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "InvaliPutException{" +
                "message='" + message + '\'' +
                '}';
    }
}
