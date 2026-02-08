package outpostState

class OutpostManager {
    val resource = mutableListOf<ObservableResource>()

    companion object {
        val instance by lazy {
            println("Менеджер создан")
            OutpostManager()
        }
    }
}