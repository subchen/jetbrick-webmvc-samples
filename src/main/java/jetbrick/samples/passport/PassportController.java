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
package jetbrick.samples.passport;

import javax.servlet.http.HttpSession;
import jetbrick.ioc.annotation.Inject;
import jetbrick.util.fastjson.JSON;
import jetbrick.web.mvc.action.*;
import jetbrick.web.mvc.action.annotation.RequestForm;
import com.alibaba.fastjson.JSONAware;

@Controller(singleton = true)
public class PassportController {
    @Inject
    private PassportService passportService;

    @Action(value = "/passport/login", method = HttpMethod.GET)
    public String login() {
        return "login.jetx";
    }

    @Action(value = "/passport/login", method = HttpMethod.POST)
    public JSONAware login(@RequestForm LoginForm form) {
        boolean valid = passportService.validate(form.getUsername(), form.getPassword());
        if (valid) {
            return JSON.ok();
        } else {
            return JSON.fail("Username or password is invalid.");
        }
    }

    @Action(value = "/passport/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
