package jetbrick.samples.controller;

import java.util.Arrays;
import java.util.Date;
import javax.xml.parsers.*;
import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.action.annotation.RequestBody;
import jetbrick.web.mvc.action.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Controller("/xml")
public final class XmlController {

    @Action("/data.xml")
    public Document data() {
        DocumentBuilder builder;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
        Document doc = builder.newDocument();
        Element users = doc.createElement("users");
        users.setAttribute("department", "XX");
        doc.appendChild(users);
        
        Element user = doc.createElement("user");
        user.setAttribute("id", "3");
        user.setAttribute("name", "张三");
        users.appendChild(user);
        
        user = doc.createElement("user");
        user.setAttribute("id", "4");
        user.setAttribute("name", "李四");
        users.appendChild(user);
        
        return doc;
    }

    @Action("/post-param")
    public Document postParam(@RequestParam("xml") Document document) {
        return document;
    }

    @Action("/post-body")
    public Document postBody(@RequestBody Document document) {
        return document;
    }

}

