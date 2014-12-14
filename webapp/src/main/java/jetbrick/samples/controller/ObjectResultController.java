package jetbrick.samples.controller;

import jetbrick.util.fastjson.JSON;
import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.result.RawText;
import com.alibaba.fastjson.JSONObject;

@Controller("/result/object")
public class ObjectResultController {

    @Action
    public Object show1() {
        return "/request.jsp";
    }

    @Action
    public Object show2() {
        return RawText.html("<font color=red>Hello</font>");
    }

    @Action
    public Object show3() {
        return JSON.ok();
    }

    @Action
    public JSONObject show4() {
        return new JSONObject();
    }

}
