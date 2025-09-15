package gg.jte.generated.ondemand.posts;
import org.example.hexlet.dto.posts.PostPage;
import org.example.hexlet.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "posts/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,6,6,6,6,7,7,7,8,8,8,13,13,13,13,13,13,13,13,13,15,15,15,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostPage page) {
		jteOutput.writeContent("\r\n<main>\r\n    <div>ID: ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getPost().getId());
		jteOutput.writeContent("</div>\r\n    <div>Name: ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getPost().getName());
		jteOutput.writeContent("</div>\r\n    <div>Content: ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getPost().getBody());
		jteOutput.writeContent("</div>\r\n    <div>\r\n        <a href=\"/posts\">Return to post list</a>\r\n    </div>\r\n    <div>\r\n        <a");
		var __jte_html_attribute_0 = NamedRoutes.postEditPath(page.getPost().getId().toString());
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Edit</a>\r\n    </div>\r\n</main>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostPage page = (PostPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
