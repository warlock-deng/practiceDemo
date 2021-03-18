package springboot.repository.mapper;


import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import springboot.repository.po.User;

import java.util.List;

/**
 * @author warlock.deng
 * Created at 2021/3/9
 */
public interface UserMapper {

    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "email", column = "email")
    })
    List<User> userList();


}
