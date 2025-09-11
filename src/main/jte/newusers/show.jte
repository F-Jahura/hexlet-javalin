<!-- src/main/jte/newusers/show.jte -->

@import org.example.hexlet.dto.newusers.NewUserPage
@param NewUserPage page

<!-- Для наглядности мы не стали включать сюда основную структуру HTML -->
<main>
      <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
      <div>${page.getUser().getEmail()}</div>
</main>