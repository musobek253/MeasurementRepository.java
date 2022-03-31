package uz.coding.appwarhouse.payload;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean isSuccess;
    private Object object;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public ApiResponse(String message, boolean isSuccess, Object object) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.object = object;
    }

    public ApiResponse(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }
}
