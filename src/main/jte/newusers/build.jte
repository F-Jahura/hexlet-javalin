<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
    <form action="/users" method="post">
      <div>
        <label>
          Firstname
          <input type="text" name="firstName" />
        </label>
      </div>
      <div>
        <label>
          Lastname
          <input type="text" name="lastName" />
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
          Password
          <input type="text" required name="password" />
        </label>
      </div>
      <input type="submit" value="Register" />
    </form>
</body>
</html>