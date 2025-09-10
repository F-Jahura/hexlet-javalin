<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
    <form action="${NamedRoutes.usersPath()}" method="post">
    <div>
            <label>
              Id
              <input type="number" name="id" />
            </label>
          </div>
      <div>
        <label>
          Firstname
          <input type="text" name="firstname" />
        </label>
      </div>
      <div>
        <label>
          Lastname
          <input type="text" name="lastname" />
        </label>
      </div>
      <div>
        <label>
          Email
          <input type="email" required name="email" />
        </label>
      </div>
      <div>
        <label>
          password
          <input type="text" required name="password" />
        </label>
      </div>
      <input type="submit" value="Register" />
    </form>
</body>
</html>