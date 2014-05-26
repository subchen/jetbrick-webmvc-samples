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

import jetbrick.lang.builder.ToStringBuilder;
import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.action.annotations.RequestForm;
import jetbrick.web.mvc.results.RawText;

@Controller("/form")
public class RequestFormController {

    @Action
    public String show() {
        return "form.jsp";
    }

    @Action
    public RawText save(@RequestForm UserInfo user) {
        return RawText.text(user.toString());
    }

    public static class UserInfo {
        private int id;
        private String name;
        private java.sql.Date birthday;
        private String[] hobbies;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public java.sql.Date getBirthday() {
            return birthday;
        }

        public void setBirthday(java.sql.Date birthday) {
            this.birthday = birthday;
        }

        public String[] getHobbies() {
            return hobbies;
        }

        public void setHobbies(String[] hobbies) {
            this.hobbies = hobbies;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflection(this);
        }
    }
}
