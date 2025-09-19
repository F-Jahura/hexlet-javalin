package gg.jte.generated.ondemand.posts;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.posts.BuildPostPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "posts/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,4,6,6,7,7,8,8,8,9,9,10,10,12,12,14,14,14,14,14,14,14,14,14,18,18,18,18,18,18,18,18,18,24,24,24,29,29,29,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildPostPage page) {
		jteOutput.writeContent("\r\n  ");
		if (page.getErrors() != null) {
			jteOutput.writeContent("\r\n      <ul>\r\n          ");
			for (var validator : page.getErrors().values()) {
				jteOutput.writeContent("\r\n              ");
				for (var error : validator) {
					jteOutput.writeContent("\r\n                  <li>");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(error.getMessage());
					jteOutput.writeContent("</li>\r\n              ");
				}
				jteOutput.writeContent("\r\n          ");
			}
			jteOutput.writeContent("\r\n      </ul>\r\n  ");
		}
		jteOutput.writeContent("\r\n\r\n  <form");
		var __jte_html_attribute_0 = NamedRoutes.postsPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" method=\"post\">\r\n    <div>\r\n      <label>\r\n        Name\r\n        <input type=\"text\" name=\"name\"");
		var __jte_html_attribute_1 = page.getName();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\r\n      </label>\r\n    </div>\r\n    <div>\r\n      <label>\r\n        Content\r\n        <textarea id=\"body\" name=\"body\" required>");
		jteOutput.setContext("textarea", null);
		jteOutput.writeUserContent(page.getBody());
		jteOutput.writeContent("</textarea>\r\n      </label>\r\n    </div>\r\n    <input type=\"submit\" value=\"Register\" />\r\n  </form>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildPostPage page = (BuildPostPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
