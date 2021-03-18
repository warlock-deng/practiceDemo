package springboot.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.bo.ResponseBO;
import springboot.business.UserBusiness;
import springboot.repository.po.User;

import java.util.List;

/**
 * @author warlock.deng
 * Created at 2021/3/18
 */
@Log4j2
@RestController("user")
public class UserService {

    @Autowired
    private UserBusiness userBusiness;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseBO<List<User>> getUsers() {
        List<User> list = userBusiness.getList();
        log.info("UtilService:{}", "getList");
        return new ResponseBO<>("success", 200, list);
    }

}
