package springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Warlock.deng
 * Created at 2019-09-25
 */
@Service
public class HelloService {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello word";
    }

}
