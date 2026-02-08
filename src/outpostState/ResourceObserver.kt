package outpostState

class ResourceObserver {
    fun observeResource(resource: ObservableResource) {
        println("Наблюдатель подключен к ресурсу: ${resource.name}")
    }
}