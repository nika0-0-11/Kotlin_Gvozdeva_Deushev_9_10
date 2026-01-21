import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager

fun main() {
    /*val manager = resources.ResourceManager()
    val minerals = resources.OutpostResource(1, "Minerals", 300)
    val gas = resources.OutpostResource(2, "Gas",100)
    val bonus = minerals.copy(amount = minerals.amount + 50)
    println("Копия минералов с бонусом: $bonus")


    manager.add(minerals)
    manager.add(gas)
    manager.printAll()*/

    val manager = ResourceManager()
    val generator = EnergyGenerator()
    val lab = ResearchLab()

    manager.add(OutpostResource(1, "Minerals", 120))
    manager.add(OutpostResource(2, "Gas", 40))
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()


}