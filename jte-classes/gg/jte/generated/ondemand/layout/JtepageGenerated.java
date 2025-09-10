package gg.jte.generated.ondemand.layout;
import org.example.hexlet.NamedRoutes;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,16,16,16,16,18,18,18,18,18,18,18,18,18,20,20,22,22,22,24,24,26,26,26,2,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n    <head>\r\n        <meta charset=\"utf-8\" />\r\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n        <title>Hello, Hexlet</title>\r\n    </head>\r\n    <body>\r\n        <p>\r\n            <h1>About us</h1>\r\n        </p>\r\n        ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n        <p>\r\n          <a");
		var __jte_html_attribute_0 = NamedRoutes.usersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">User Details</a>\r\n        </p>\r\n        ");
		if (footer != null) {
			jteOutput.writeContent("\r\n        <div class=\"footer\">\r\n            ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(footer);
			jteOutput.writeContent("\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		render(jteOutput, jteHtmlInterceptor, content, footer);
	}
}
