package gg.jte.generated.ondemand.posts;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.posts.PostsPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "posts/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,13,13,13,15,15,15,15,15,15,15,15,15,15,15,15,17,17,20,20,20,20,20,20,20,20,20,24,24,25,25,25,25,26,26,27,27,28,28,28,28,29,29,33,33,33,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostsPage page) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n        <html lang=\"ru\">\r\n        <head>\r\n            <meta charset=\"UTF-8\">\r\n            <title>User Management</title>\r\n        </head>\r\n        <body>\r\n<main>\r\n    <ul>\r\n    ");
		for (var post : page.getPosts()) {
			jteOutput.writeContent("\r\n        <li>\r\n            <a");
			var __jte_html_attribute_0 = NamedRoutes.postPath(post.getId());
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeContent(" href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">");
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(post.getName());
			jteOutput.writeContent("</a>\r\n        </li>\r\n    ");
		}
		jteOutput.writeContent("\r\n    </ul>\r\n    <p>\r\n    <a");
		var __jte_html_attribute_1 = NamedRoutes.buildPostPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Add new post</a>\r\n    </p>\r\n\r\n    <div>\r\n        ");
		if (page.getCurrentPage() > 1) {
			jteOutput.writeContent("\r\n            <a href=\"?page=");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(page.getCurrentPage() - 1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">Back</a>\r\n        ");
		}
		jteOutput.writeContent("\r\n        ");
		if (page.getCurrentPage() < page.getTotalPages()) {
			jteOutput.writeContent("\r\n            <a href=\"?page=");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(page.getCurrentPage() + 1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">Next</a>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </div>\r\n</main>\r\n </body>\r\n </html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostsPage page = (PostsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
