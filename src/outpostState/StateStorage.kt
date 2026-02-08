package outpostState
import java.io.File

object StateStorage {
    private const val FILE_NAME = "outpost_state_dz.txt"

    fun save(resource: List<ObservableResource>) {
        val file = File(FILE_NAME)

        file.writeText(
            resource.joinToString("\n") {
                "${it.name.toString()};${it.amount}"
            }
        )
        println("Состояние сохранено в файл $FILE_NAME")
    }

    fun load(): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) {
            println("Файл состояния не найден")
            return emptyList()
        }

        return file.readLines().map { line ->
            val (name, amount) = line.split(";")
            ObservableResource(name, amount.toInt())
        }
    }
}