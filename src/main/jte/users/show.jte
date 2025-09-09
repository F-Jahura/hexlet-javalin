<!-- src/main/jte/users/show.jte -->

@import org.example.hexlet.dto.users.UserPage
@param UserPage page

<!-- Для наглядности мы не стали включать сюда основную структуру HTML -->
<main>
      <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
      <div>${page.getUser().getEmail()}</div>
</main>