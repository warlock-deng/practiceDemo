package springboot.business;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.repository.mapper.UserMapper;
import springboot.repository.po.User;

import java.util.List;

/**
 * @author warlock.deng
 * Created at 2021/3/10
 */
@Log4j2
@Service
public class UserBusiness {

    @Autowired
    private UserMapper userMapper;

    public List<User> getList() {
        log.info("UserBusiness:{}", "getList");
        return userMapper.userList();
    }
}
