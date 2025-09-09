package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {41,41,41,41,41,41,41,41,41,41,41};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <title>Registration</title>\r\n</head>\r\n<body>\r\n    <form action=\"/users\" method=\"post\">\r\n    <div>\r\n            <label>\r\n              Id\r\n              <input type=\"number\" name=\"id\" />\r\n            </label>\r\n          </div>\r\n      <div>\r\n        <label>\r\n          Firstname\r\n          <input type=\"text\" name=\"firstname\" />\r\n        </label>\r\n      </div>\r\n      <div>\r\n        <label>\r\n          Lastname\r\n          <input type=\"text\" name=\"lastname\" />\r\n        </label>\r\n      </div>\r\n      <div>\r\n        <label>\r\n          Email\r\n          <input type=\"email\" required name=\"email\" />\r\n        </label>\r\n      </div>\r\n      <div>\r\n        <label>\r\n          password\r\n          <input type=\"text\" required name=\"password\" />\r\n        </label>\r\n      </div>\r\n      <input type=\"submit\" value=\"Register\" />\r\n    </form>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
