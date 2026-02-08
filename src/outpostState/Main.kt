package outpostState

fun main() {
    println("Создание менеджера...")
    val manager = OutpostManager()

    val minerals = ObservableResource("Minerals",100)
    val gas = ObservableResource("Gas", 200)

    manager.addResource(minerals)
    manager.addResource(gas)

    println("\nДоступные ресурсы:")
    manager.resources.forEach { println("- ${it.name}: ${it.amount}") }

    println("\nИзменяем количество ресурсов:")
    minerals.amount = 120
    gas.amount = 180

    println("\nСохраняем состояние...")
    StateStorage.save(manager.resources)

    println("\nЗагружаем состояние...")
    val loadedResource = StateStorage.load()

    println("\nЗагружаем ресурсы:")
    loadedResource.forEach { println("- ${it.name}: ${it.amount}") }

}