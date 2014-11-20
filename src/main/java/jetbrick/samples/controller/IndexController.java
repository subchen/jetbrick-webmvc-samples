/**
 * Copyright 2013-2014 Guoqiang Chen, Shanghai, China. All rights reserved.
 *
 * Email: subchen@gmail.com
 * URL: http://subchen.github.io/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrick.samples.controller;

import jetbrick.bean.asm.AsmFactory;
import jetbrick.web.mvc.Model;
import jetbrick.web.mvc.RequestContext;
import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.action.annotation.PathVariable;
import jetbrick.web.mvc.action.annotation.RequestParam;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONObject;

@Controller
public class IndexController {

    static {
        AsmFactory.setDebugEnabled(true);
    }

    @Action("/")
    public String index(RequestContext ctx) {
        return "jetx:";
    }

    @Action("/request.jetx")
    public String requestJetx() {
        return "request.jetx";
    }

    @Action("/json")
    public JSONAware json(RequestContext ctx) {
        ctx.getModel().add("test", "aaaa");
        return null;
    }

    @Action("/model")
    public JSONAware model(Model model, @RequestParam("id") int id) {
        model.put("id", id);
        return new JSONObject(model);
    }

    @Action("/path/{id}")
    public JSONAware path(Model model, @PathVariable("id") int id) {
        model.put("id", id);
        return new JSONObject(model);
    }

    @Action("/freemarker")
    public String freemarker(Model model) {
        //model.put("user", "aa");
        return "1.ftl";
    }
}
