package modules

import resources.OutpostResource
import resources.ResourceManager

class EnergyGenerator : OutpostModule("Генератор энергии") {
    override fun performAction(manager: ResourceManager) {
        println("Генератор работает... Производит 20 жнергии")
        val energy = manager.get("Energy")

        if (energy != null) {
            energy.amount += 20
        } else {
            manager.add(OutpostResource(9, "Energy",20))
        }
    }


}