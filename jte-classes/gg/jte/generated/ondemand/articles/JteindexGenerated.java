package gg.jte.generated.ondemand.articles;
import org.example.hexlet.dto.articles.ArticlesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "articles/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,19,19,19,22,22,22,25,25,25,28,28,28,31,31,37,37,37,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ArticlesPage page) {
		jteOutput.writeContent("\r\n<html lang=\"en\">\r\n  <head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Hello Hexlet</title>\r\n    </head>\r\n    <body>\r\n        <div class=\"mx-auto p-4 py-md-5\">\r\n            <main>\r\n                <h1>All articles</h1>\r\n\r\n                <div class=\"mb-3\">\r\n                    <a href=\"/articles/build\">Create new article</a>\r\n                </div>\r\n\r\n                <table class=\"table table-striped\">\r\n                    ");
		for (var article : page.getArticles()) {
			jteOutput.writeContent("\r\n                        <tr>\r\n                            <td>\r\n                                ");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(article.getId());
			jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                ");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(article.getTitle());
			jteOutput.writeContent("\r\n                            </td>\r\n                            <td>\r\n                                ");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(article.getContent());
			jteOutput.writeContent("\r\n                            </td>\r\n                        </tr>\r\n                    ");
		}
		jteOutput.writeContent("\r\n                </table>\r\n            </main>\r\n        </div>\r\n    </body>\r\n</html>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ArticlesPage page = (ArticlesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
