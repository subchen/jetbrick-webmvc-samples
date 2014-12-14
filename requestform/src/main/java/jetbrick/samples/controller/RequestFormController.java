package jetbrick.samples.controller;

import jetbrick.util.builder.ToStringBuilder;
import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.action.annotation.RequestForm;
import jetbrick.web.mvc.result.RawText;

@Controller("/requestform")
public class RequestFormController {

    @Action
    public String show() {
        return "form.jetx";
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
