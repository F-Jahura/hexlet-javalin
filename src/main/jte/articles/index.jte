@import org.example.hexlet.dto.articles.ArticlesPage
@param ArticlesPage page

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet</title>
    </head>
    <body>
        <div class="mx-auto p-4 py-md-5">
            <main>
                <h1>All articles</h1>

                <div class="mb-3">
                    <a href="/articles/build">Create new article</a>
                </div>

                <table class="table table-striped">
                    @for(var article : page.getArticles())
                        <tr>
                            <td>
                                ${article.getId()}
                            </td>
                            <td>
                                ${article.getTitle()}
                            </td>
                            <td>
                                ${article.getContent()}
                            </td>
                        </tr>
                    @endfor
                </table>
            </main>
        </div>
    </body>
</html>
