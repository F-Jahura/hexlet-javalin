@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.newusers.BuildNewUserPage
  @param BuildNewUserPage page

  @if(page.getErrors() != null)
      <ul>
          @for(var validator : page.getErrors().values())
              @for(var error : validator)
                  <li>${error.getMessage()}</li>
              @endfor
          @endfor
      </ul>
  @endif

  <form action="${NamedRoutes.usersPath()}" method="post">
    <div>
      <label>
        FirstName
        <input type="text" name="firstName" value="${page.getFirstName()}" />
      </label>
    </div>
    <div>
       <label>
          LastName
          <input type="text" name="lastName" value="${page.getLastName()}" />
       </label>
     </div>
    <div>
      <label>
        Email
        <input type="email" required name="email" value="${page.getEmail()}" />
      </label>
    </div>
    <div>
      <label>
        Password
        <input type="password" required name="password" />
      </label>
    </div>
    <div>
      <label>
        Password Confirm
        <input type="password" required name="passwordConfirmation" />
      </label>
    </div>
    <input type="submit" value="Register" />
  </form>