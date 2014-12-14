package jetbrick.samples.controller;

import java.util.Map;
import java.util.HashMap;
import jetbrick.util.JSONUtils;
import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.action.annotation.RequestParam;
import jetbrick.web.mvc.multipart.FilePart;
import jetbrick.web.mvc.result.RawText;

@Controller("/fileupload")
public final class FileUploadController {

    @Action("/form")
    public String form() {
        return "/fileupload-form.jetx";
    }

    @Action("/single-file")
    public RawText singleFile(FilePart file) {
        return RawText.text(file.toString());
    }

    @Action("/multi-files")
    public RawText multiFiles(@RequestParam String name, @RequestParam FilePart file1, FilePart[] files) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("file1", file1);
        map.put("files", files);
        return RawText.json(JSONUtils.toJSONString(map));
    }
}

