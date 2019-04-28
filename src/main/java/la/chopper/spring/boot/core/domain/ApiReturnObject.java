package la.chopper.spring.boot.core.domain;

import java.io.Serializable;

/**
 * @author TonyTonyChopper
 */
public class ApiReturnObject implements Serializable {

    private static final long serialVersionUID = -2080220038203056414L;
    private String errorCode = "00";
    private Object errorMessage;
    private Object returnObject;


    public ApiReturnObject(String errorCode, Object errorMessage, Object returnObject) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.returnObject = returnObject;
    }

    public ApiReturnObject(Object errorMessage, Object returnObject) {
        super();
        this.errorMessage = errorMessage;
        this.returnObject = returnObject;
    }

    public ApiReturnObject(Object returnObject) {
        super();
        this.returnObject = returnObject;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

}
