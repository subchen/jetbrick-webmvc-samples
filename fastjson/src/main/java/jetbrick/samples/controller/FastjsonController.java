package jetbrick.samples.controller;

import java.util.Arrays;
import java.util.Date;
import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.action.annotation.RequestBody;
import jetbrick.web.mvc.action.annotation.RequestParam;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONObject;

@Controller("/fastjson")
public final class FastjsonController {

    @SuppressWarnings("unchecked")
    @Action("/data.json")
    public JSONObject data() {
        JSONObject json = new JSONObject();
        json.put("str", "你好");
        json.put("list", Arrays.asList(1,2,"aa",true, new Date()));
        return json;
    }

    @Action("/post-param")
    public JSONObject postParam(@RequestParam JSONObject json) {
        return json;
    }

    @Action("/post-body")
    public JSONAware postBody(@RequestBody JSONAware json) {
        return json;
    }

}

