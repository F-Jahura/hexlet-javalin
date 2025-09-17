@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.posts.PostsPage
@param PostsPage page

<!DOCTYPE html>
        <html lang="ru">
        <head>
            <meta charset="UTF-8">
            <title>User Management</title>
        </head>
        <body>
<main>
    <ul>
    @for(var post : page.getPosts())
        <li>
            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
        </li>
    @endfor
    </ul>
    <p>
    <a href="${NamedRoutes.buildPostPath()}">Add new post</a>
    </p>

    <div>
        @if(page.getCurrentPage() > 1)
            <a href="?page=${page.getCurrentPage() - 1}">Back</a>
        @endif
        @if(page.getCurrentPage() < page.getTotalPages())
            <a href="?page=${page.getCurrentPage() + 1}">Next</a>
        @endif
    </div>
</main>
 </body>
 </html>