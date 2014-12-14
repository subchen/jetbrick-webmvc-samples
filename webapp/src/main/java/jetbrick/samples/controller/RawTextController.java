package jetbrick.samples.controller;

import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.result.RawText;

@Controller("/rawtext")
public class RawTextController {

    @Action
    public RawText html() {
        return RawText.html("<font color=red>RED 颜色</font>");
    }

    @Action
    public RawText text() {
        return RawText.text("<font color=red>RED 颜色</font>");
    }

    @Action
    public RawText json() {
        return RawText.json("[1,2,3]");
    }

    @Action
    public RawText js() {
        return RawText.js("var a = 0;");
    }

    @Action
    public RawText css() {
        return RawText.css("body{}");
    }

    @Action
    public RawText xml() {
        return RawText.xml("<node/>");
    }

}
