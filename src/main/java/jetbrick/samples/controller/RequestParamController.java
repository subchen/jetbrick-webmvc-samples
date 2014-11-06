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

import jetbrick.util.fastjson.JSON;
import jetbrick.web.mvc.Model;
import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.action.annotation.RequestParam;
import com.alibaba.fastjson.JSONAware;

@Controller("/param")
public class RequestParamController {

    @Action
    public JSONAware name(Model model, @RequestParam("id") int id, @RequestParam("name") String name) {
        model.add("id", id);
        model.add("name", name);
        return JSON.toJSON(model);
    }

    @Action
    public JSONAware auto(Model model, @RequestParam int id, @RequestParam String name) {
        model.add("id", id);
        model.add("name", name);
        return JSON.toJSON(model);
    }

    @Action
    public JSONAware ids(Model model, @RequestParam int[] id) {
        model.add("id", id);
        return JSON.toJSON(model);
    }

    @Action
    public JSONAware names(Model model, @RequestParam String[] name) {
        model.add("name", name);
        return JSON.toJSON(model);
    }
}
