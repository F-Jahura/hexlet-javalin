package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,10,10,10,10,10,10,10,10,10,10,13,13,15,15,17,17,20,20,20,23,23,23,23,23,23,23,23,23,23,24,24,24,25,25,25,28,28,30,30,32,32,32,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n<html>\r\n    <head>\r\n        <title>Hello, Hexlet!</title>\r\n    </head>\r\n    <body>\r\n        <h2>Users List:</h2>\r\n        <form action=\"/users\" method=\"get\">\r\n        <input type=\"search\" name=\"term\"");
		var __jte_html_attribute_0 = page.getTerm();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" />\r\n        <input type=\"submit\" value=\"Search\" />\r\n        </form>\r\n        ");
		if (page.getUsers().isEmpty()) {
			jteOutput.writeContent("\r\n            <p>There are no users.</p>\r\n        ");
		} else {
			jteOutput.writeContent("\r\n        <table class=\"table table-striped\">\r\n            ");
			for (var user : page.getUsers()) {
				jteOutput.writeContent("\r\n               <tr>\r\n                   <td>\r\n                       ");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getId());
				jteOutput.writeContent("\r\n                   </td>\r\n                   <td>\r\n                       <a href=\"/users/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(user.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(user.getFirstName());
				jteOutput.writeContent(" ");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(user.getLastName());
				jteOutput.writeContent("</a>\r\n                       ");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getEmail());
				jteOutput.writeContent("\r\n                       ");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getPassword());
				jteOutput.writeContent("\r\n                   </td>\r\n               </tr>\r\n            ");
			}
			jteOutput.writeContent("\r\n            </table>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
