@import org.example.hexlet.dto.sessionuser.LoginPage
@import org.example.hexlet.NamedRoutes
@param LoginPage page

        @if(page.getError() != "")
            <div class="mb-3">
                ${page.getError()}
            </div>
        @endif
        <div class="mx-auto p-4 py-md-5">
            <form action="${NamedRoutes.loginPath()}" method="post">
                <div class="mb-3">
                    <label class="form-label">
                    Name
                    <input type="text" class="form-control" name="name" value="${page.getName()}" />
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">
                    Password
                    <input type="password" class="form-control" name="password" />
                    </label>
                </div>
                <input type="submit" class="btn btn-primary" value="Sign in" />
            </form>
        </div>
