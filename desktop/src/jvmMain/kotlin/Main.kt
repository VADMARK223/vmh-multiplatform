import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import com.vadmark223.common.App
import com.vadmark223.common.repository.UsersRepo
import com.vadmark223.common.repository.UsersRepoImpl
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Users : LongIdTable("users") {
    val firstName = varchar("first_name", 50)
    val lastName = varchar("last_name", 50)
}

fun main() = application {
    val usersRepo: UsersRepo = UsersRepoImpl()
    val database =
        Database.connect(
            url = "jdbc:postgresql://localhost:5432/vdh",
            driver = "org.postgresql.Driver",
            user = "postgres",
            password = "postgres"
        )
    transaction(database) {
        addLogger(StdOutSqlLogger)

        for (user in Users.selectAll()) {
            usersRepo.addUser(user[Users.id].value, user[Users.firstName], user[Users.lastName])
        }
    }

    val icon = painterResource("favicon.ico")
    val width = 1000.dp
    val height = 700.dp
    val state = rememberWindowState(
        size = DpSize(width, height),
        position = WindowPosition(2300.dp, 300.dp),
        isMinimized = false
    )

    Tray(
        icon = icon,
        menu = {
            Item("Close app", onClick = ::exitApplication)
        }
    )

    Window(
        onCloseRequest = ::exitApplication,
        state = state,
        true,
        "Vadmark`s messenger",
        icon = icon
    ) {

//        usersRepo.addUser("Евгений", "Васильев")
//        usersRepo.addUser("Андрей", "Головнев")
//        usersRepo.addUser("Герман","Доронин")
//        usersRepo.addUser("Михаил", "Трищакин")
//        usersRepo.addUser("Роман", "Анисимов")
//        usersRepo.addUser("Иван", "Станченко")
//        usersRepo.addUser("Вадим", "Маркитанов")
//        usersRepo.addUser("Дмитрий","Капустин")
//        usersRepo.addUser("Кристина", "Селиверстова")
        App(usersRepo)
    }
}
