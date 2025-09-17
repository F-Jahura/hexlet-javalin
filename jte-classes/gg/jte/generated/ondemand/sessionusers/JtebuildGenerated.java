package gg.jte.generated.ondemand.sessionusers;
import org.example.hexlet.dto.sessionuser.LoginPage;
import org.example.hexlet.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "sessionusers/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,4,6,6,6,8,8,10,10,10,10,10,10,10,10,10,14,14,14,14,14,14,14,14,14,26,26,26,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, LoginPage page) {
		jteOutput.writeContent("\r\n        ");
		if (page.getError() != "") {
			jteOutput.writeContent("\r\n            <div class=\"mb-3\">\r\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getError());
			jteOutput.writeContent("\r\n            </div>\r\n        ");
		}
		jteOutput.writeContent("\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            <form");
		var __jte_html_attribute_0 = NamedRoutes.loginPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"post\">\r\n                <div class=\"mb-3\">\r\n                    <label class=\"form-label\">\r\n                    Name\r\n                    <input type=\"text\" class=\"form-control\" name=\"name\"");
		var __jte_html_attribute_1 = page.getName();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\r\n                    </label>\r\n                </div>\r\n                <div class=\"mb-3\">\r\n                    <label class=\"form-label\">\r\n                    Password\r\n                    <input type=\"password\" class=\"form-control\" name=\"password\" />\r\n                    </label>\r\n                </div>\r\n                <input type=\"submit\" class=\"btn btn-primary\" value=\"Sign in\" />\r\n            </form>\r\n        </div>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		LoginPage page = (LoginPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
