@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.posts.EditPostPage

@param EditPostPage page

<h1>Edit Post</h1>

<form method="post" action="${NamedRoutes.postUpdatePath(page.getId().toString())}">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${page.getName()}" required>
    </div>
    <div>
        <label for="body">Content:</label>
        <textarea id="body" name="body" required>${page.getBody()}</textarea>
    </div>
    <button type="submit">Save edited information</button>
</form>