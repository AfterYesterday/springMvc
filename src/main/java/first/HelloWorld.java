package first;

import cj.aop.MethodLog;
import cj.aop.TabLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = ("/index"))
public class HelloWorld {
    //@MethodLog(remark = "aop注解日志测试",desc="desc111")
    //@MethodLog
    @TabLog
    @RequestMapping(value = "/hello.do")
        public String hello(){
        System.out.print("ceshi");
        return "/index";
    }
}
