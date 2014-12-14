package jetbrick.samples.controller;

import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;

@Controller("/freemarker")
public final class FreemarkerController {

    
    @Action("/hello")
    public String hello() {
        return "/hello.ftl";
    }

}

