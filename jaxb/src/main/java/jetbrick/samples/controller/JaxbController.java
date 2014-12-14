package jetbrick.samples.controller;

import java.util.Arrays;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.action.annotation.RequestBody;
import jetbrick.web.mvc.action.annotation.RequestParam;

@Controller("/jaxb")
public final class JaxbController {

    @Action("/data.xml")
    public JAXBElement<Users> data() {
        Users users = new Users();
        
        User user = new User();
        user.setId("1");
        user.setName("张三");
        users.setUsers(Arrays.asList(user));

        return new JAXBElement<Users>(new QName("users"), Users.class, users);
    }

    @Action("/post-param")
    public JAXBElement<Users> postParam(@RequestParam("xml") JAXBElement<Users> jaxb) {
        return jaxb;
    }

    @Action("/post-body")
    public JAXBElement<Users> postBody(@RequestBody JAXBElement<Users> jaxb) {
        return jaxb;
    }

}
