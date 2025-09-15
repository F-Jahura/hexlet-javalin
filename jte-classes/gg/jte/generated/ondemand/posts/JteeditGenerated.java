package gg.jte.generated.ondemand.posts;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.posts.EditPostPage;
public final class JteeditGenerated {
	public static final String JTE_NAME = "posts/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,7,7,7,7,7,7,7,7,7,7,10,10,10,10,10,10,10,10,10,14,14,14,17,17,17,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, EditPostPage page) {
		jteOutput.writeContent("\r\n<h1>Edit Post</h1>\r\n\r\n<form method=\"post\"");
		var __jte_html_attribute_0 = NamedRoutes.postUpdatePath(page.getId().toString());
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" action=\"");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("form", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\r\n    <div>\r\n        <label for=\"name\">Name:</label>\r\n        <input type=\"text\" id=\"name\" name=\"name\"");
		var __jte_html_attribute_1 = page.getName();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required>\r\n    </div>\r\n    <div>\r\n        <label for=\"body\">Content:</label>\r\n        <textarea id=\"body\" name=\"body\" required>");
		jteOutput.setContext("textarea", null);
		jteOutput.writeUserContent(page.getBody());
		jteOutput.writeContent("</textarea>\r\n    </div>\r\n    <button type=\"submit\">Save edited information</button>\r\n</form>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		EditPostPage page = (EditPostPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
