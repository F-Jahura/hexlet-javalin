@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.sessionuser.MainPage
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
  </head>
  <body>
    <main>
      <h1>My page</h1>
      <p> Please sing in your page </p>
       @if(page.getName() != null)
          <p>Hello, ${page.getName().toString()}</p>
          <form action="${NamedRoutes.logoutPath()}" method="POST">
            <button type="submit">Sign out</button>
          </form>
       @else
          <p>
            <a href="${NamedRoutes.buildSessionPath()}">Sign in</a>
          </p>
       @endif

       @if(page != null && page.getFlash() != null)
          <div class="alert alert-success" role="alert">
             <p>${page.getFlash()}</p>
          </div>
       @endif
    </main>
  </body>
</html>