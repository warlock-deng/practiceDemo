package springboot.bo;

import lombok.*;

/**
 * @author warlock.deng
 * Created at 2021/3/4
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBO<T> {

    private String message;

    private int code;

    private T data;

}
