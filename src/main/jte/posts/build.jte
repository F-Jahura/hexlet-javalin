@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.posts.BuildPostPage
@param BuildPostPage page

  @if(page.getErrors() != null)
      <ul>
          @for(var validator : page.getErrors().values())
              @for(var error : validator)
                  <li>${error.getMessage()}</li>
              @endfor
          @endfor
      </ul>
  @endif

  <form action="${NamedRoutes.postsPath()}" method="post">
    <div>
      <label>
        Name
        <input type="text" name="name" value="${page.getName()}" />
      </label>
    </div>
    <div>
      <label>
        Content
        <textarea id="body" name="body" required>${page.getBody()}</textarea>
      </label>
    </div>
    <input type="submit" value="Register" />
  </form>
