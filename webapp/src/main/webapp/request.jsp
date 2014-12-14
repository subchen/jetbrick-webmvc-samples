<%@page contentType="text/html" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset='utf-8'>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>JSP Samples</title>
	</head>

<body>

	<pre>
		<xml>
<%
    String FORMAT = "%20s: %s%n";
    PrintWriter os = new PrintWriter(out);
    os.println("Request Basic: ====================================");
    os.printf(FORMAT, "ContextPath", request.getContextPath());
    os.printf(FORMAT, "PathInfo", request.getPathInfo());
    os.printf(FORMAT, "ServletPath", request.getServletPath());
    os.printf(FORMAT, "Request URI", request.getRequestURI());
    os.printf(FORMAT, "Request URL", request.getRequestURL());
    os.printf(FORMAT, "QueryString", request.getQueryString());
    os.printf(FORMAT, "Method", request.getMethod());
    os.println();

    os.printf(FORMAT, "CharacterEncoding", request.getCharacterEncoding());
    os.printf(FORMAT, "ContentType", request.getContentType());
    os.printf(FORMAT, "ContentLength", request.getContentLength());
    os.printf(FORMAT, "Locale", request.getLocale());
    os.printf(FORMAT, "RemoteAddr", request.getRemoteAddr());
    os.println();

    os.println("Request Headers: ====================================");
    Enumeration<String> header = request.getHeaderNames();
    while (header.hasMoreElements()) {
        String name = header.nextElement();
        String value = request.getHeader(name);
        os.printf(FORMAT, name, value);
    }
    os.println();

    os.println("Request Parameters: ====================================");
    Enumeration<String> param = request.getParameterNames();
    while (param.hasMoreElements()) {
        String name = param.nextElement();
        String value[] = request.getParameterValues(name);
        os.printf(FORMAT, name, jetbrick.util.StringUtils.join(value, ", "));
    }
    os.println();

    os.println("Request Cookies: ====================================");
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            os.printf(FORMAT, cookie.getName(), cookie.getValue());
        }
    }
    os.println();

    os.flush();
%>
</xml>
	</pre>

</body>
</html>
