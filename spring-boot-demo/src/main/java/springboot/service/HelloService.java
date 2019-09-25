package springboot.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Warlock.deng
 * Created at 2019-09-25
 */
@RestController("/")
public class HelloService {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello word";
    }

}
