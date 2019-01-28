import com.google.gson.annotations.Expose;

public class ActionResult<T> {
	
	@Expose
    private Boolean success = false;
    @Expose
    private Integer resultCode;
    @Expose
    private String resultMessage;
    @Expose
    private T result;

    public T getResult() {return result; }
    public void setResult(T t) {
        this.result = t;
    }

    public Integer getResultCode() {
        return resultCode;
    }
    public void  setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Boolean getSuccessfull() {
        return this.success;
    }

    public void setSuccessfull(T result) {
        this.success = true;
        this.result = result;
        this.resultCode = 0;
        this.resultMessage = "Success";
    }

    public void setFailed(Integer resultCode, String resultMessage) {
        this.success = false;
        this.result = null;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

}
