package outpostState

class OutpostManager {
    val resourcesList = mutableListOf<ObservableResource>()

    val resources: List<ObservableResource> by lazy {
        println("Менеджер ресурсов создан")
        resourcesList
    }

    fun addResource(resource: ObservableResource) {
        resourcesList.add(resource)
    }

    /*val resource = mutableListOf<ObservableResource>()

    companion object {
        val instance by lazy {
            println("Менеджер создан")
            OutpostManager()
        }
    }*/
}