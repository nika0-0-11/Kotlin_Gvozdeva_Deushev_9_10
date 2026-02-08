package outpostState

import kotlin.properties.Delegates

class ObservableResource(val name: String, initialAmount: Int) {
    var amount by Delegates.observable(initialAmount) { _, old, new ->
        println("Ресурс $name изменен: $old -> $new")
    }
}