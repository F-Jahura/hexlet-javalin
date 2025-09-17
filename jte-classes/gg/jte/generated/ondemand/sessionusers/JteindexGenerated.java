package gg.jte.generated.ondemand.sessionusers;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.sessionuser.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "sessionusers/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,15,15,15,16,16,16,17,17,17,17,17,17,17,17,17,20,20,22,22,22,22,22,22,22,22,22,24,24,26,26,28,28,28,30,30,33,33,33,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n  <head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Hello Hexlet!</title>\r\n  </head>\r\n  <body>\r\n    <main>\r\n      <h1>My page</h1>\r\n      <p> Please sing in your page </p>\r\n       ");
		if (page.getName() != null) {
			jteOutput.writeContent("\r\n          <p>Hello, ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(page.getName().toString());
			jteOutput.writeContent("</p>\r\n          <form");
			var __jte_html_attribute_0 = NamedRoutes.logoutPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeContent(" action=\"");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("form", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(" method=\"POST\">\r\n            <button type=\"submit\">Sign out</button>\r\n          </form>\r\n       ");
		} else {
			jteOutput.writeContent("\r\n          <p>\r\n            <a");
			var __jte_html_attribute_1 = NamedRoutes.buildSessionPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeContent(" href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">Sign in</a>\r\n          </p>\r\n       ");
		}
		jteOutput.writeContent("\r\n\r\n       ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\r\n          <div class=\"alert alert-success\" role=\"alert\">\r\n             <p>");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("</p>\r\n          </div>\r\n       ");
		}
		jteOutput.writeContent("\r\n    </main>\r\n  </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
