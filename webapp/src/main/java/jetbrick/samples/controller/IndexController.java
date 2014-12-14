package jetbrick.samples.controller;

import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;

@Controller
public final class IndexController {

    @Action("/")
    public String index() {
        return "index.jetx";
    }

}
