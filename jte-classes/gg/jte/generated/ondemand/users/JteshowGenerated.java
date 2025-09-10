package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {2,2,3,3,3,5,5,7,7,7,7,7,7,8,8,8,9,9,9,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\r\n");
		jteOutput.writeContent("\r\n<main>\r\n      <h2>");
		jteOutput.setContext("h2", null);
		jteOutput.writeUserContent(page.getUser().getFirstName());
		jteOutput.writeContent(" ");
		jteOutput.setContext("h2", null);
		jteOutput.writeUserContent(page.getUser().getLastName());
		jteOutput.writeContent("</h2>\r\n      <div>");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getUser().getEmail());
		jteOutput.writeContent("</div>\r\n</main>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
