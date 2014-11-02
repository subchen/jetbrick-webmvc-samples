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

import jetbrick.samples.JSON;
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
