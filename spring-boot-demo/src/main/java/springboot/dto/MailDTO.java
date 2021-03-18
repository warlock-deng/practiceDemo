package springboot.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author warlock.deng
 * Created at 2021/3/4
 */
@Getter
@Setter
@ToString
public class MailDTO {

    private String toAddress;

    private String subject;

    private String body;

}
