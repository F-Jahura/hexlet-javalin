@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.posts.PostPage
@param PostPage page

<!-- Для наглядности мы не стали включать сюда основную структуру HTML -->
<main>
      <div>${page.getPost().getName()}</div>
      <div>${page.getPost().getBody()}</div>
      <div>
         <a href="${NamedRoutes.postsPath()}">Post list</a>
      </div>
</main>