@import org.example.hexlet.dto.newusers.NewUsersPage
@param NewUsersPage page

        <!DOCTYPE html>
        <html lang="ru">
        <head>
            <meta charset="UTF-8">
            <title>User Management</title>
        </head>
        <body>
            <h1>User Details</h1>

            <div>
                <a href="/users/build">Register new user</a>
            </div>

            <p>
                User list
            </p>

            <!-- Проверяем, есть ли пользователи -->
            @if(page.getNewusers().size() > 0)
                <table>
                    <tbody>
                        @for(var user : page.getNewusers())
                            <tr>
                                <td>${user.getId()}</td>
                                <td>${user.getFirstName()} ${user.getLastName()}</td>
                            </tr>
                        @endfor
                    </tbody>
                </table>
            @else
                <p>No users available.</p>
            @endif
        </body>
        </html>

