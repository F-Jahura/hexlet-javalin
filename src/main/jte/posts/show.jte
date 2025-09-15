@import org.example.hexlet.dto.posts.PostPage
@import org.example.hexlet.NamedRoutes

@param PostPage page

<main>
    <div>ID: ${page.getPost().getId()}</div>
    <div>Name: ${page.getPost().getName()}</div>
    <div>Content: ${page.getPost().getBody()}</div>
    <div>
        <a href="/posts">Return to post list</a>
    </div>
    <div>
        <a href="${NamedRoutes.postEditPath(page.getPost().getId().toString())}">Edit</a>
    </div>
</main>