@import gg.jte.Content
@param Content content
@param Content footer = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hello, Hexlet</title>
    </head>
    <body>
        <p>
            <h1>About us</h1>
        </p>
        ${content}
        <p>
          <a href="/users">User Details</a>
        </p>
        @if (footer != null)
        <div class="footer">
            ${footer}
        </div>
    @endif
    </body>
</html>