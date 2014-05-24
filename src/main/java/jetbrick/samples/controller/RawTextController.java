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

import jetbrick.web.mvc.action.Action;
import jetbrick.web.mvc.action.Controller;
import jetbrick.web.mvc.results.RawText;

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
