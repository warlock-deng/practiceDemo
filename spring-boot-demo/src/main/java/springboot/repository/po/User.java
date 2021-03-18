package springboot.repository.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author warlock.deng
 * Created at 2021/3/9
 */
@Getter
@Setter
@ToString
public class User {

    private int id;

    private String name;

    private int age;

    private String email;
    

}
