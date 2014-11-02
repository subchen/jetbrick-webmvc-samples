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
package jetbrick.samples.upload;

import jetbrick.web.mvc.Model;
import jetbrick.web.mvc.action.*;
import jetbrick.web.mvc.action.annotation.RequestParam;
import jetbrick.web.mvc.multipart.FilePart;
import com.alibaba.fastjson.JSONAware;

@Controller(singleton = true)
public class UploadController {

    @Action(value = "/upload/", method = HttpMethod.GET)
    public String list(Model model) {
        return "fileupload.jetx";
    }

    @Action(value = "/upload/single", method = HttpMethod.POST)
    public JSONAware doPost(@RequestParam("name") String name, FilePart file, Model model) {
        model.add("name", name);
        model.add("file", file);
        return null;
    }

    @Action(value = "/upload/multi", method = HttpMethod.POST)
    public JSONAware doPost(@RequestParam("name1") String name1, FilePart[] files, Model model) {
        model.add("name1", name1);
        model.add("files", files);
        return null;
    }
}
