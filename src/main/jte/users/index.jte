@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

<html>
    <head>
        <title>Hello, Hexlet!</title>
    </head>
    <body>
        <h2>Users List:</h2>
        <form action="${NamedRoutes.usersPath()}" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
        </form>
        @if(page.getUsers().isEmpty())
            <p>There are no users.</p>
        @else
        <table class="table table-striped">
            @for(var user : page.getUsers())
               <tr>
                   <td>
                       ${user.getId()}
                   </td>
                   <td>
                       <a href="${NamedRoutes.userPath(user.getId())}">${user.getFirstName()} ${user.getLastName()}</a>
                       ${user.getEmail()}
                       ${user.getPassword()}
                   </td>
               </tr>
            @endfor
            </table>
        @endif
    </body>
</html>