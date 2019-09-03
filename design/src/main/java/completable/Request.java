package completable;

/**
 * 说明
 *
 * @author warlock.deng
 * Created at 2019/5/6 16:14
 */
public class Request {

    private int code;

    private Job data;

    private String time;

    private String message;

    private String taskId;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Job getData() {
        return data;
    }

    public void setData(Job data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
