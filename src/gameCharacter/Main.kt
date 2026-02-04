package gameCharacter

fun handleState(state: CharacterState) {
    when (state) {
        is Inactive -> println("Персонаж бездействует")
        is Running -> println("Персонаж бежит")
        is Attacking -> println("Персонаж атакует с уроном ${state.damage}")
        is Dead -> println("Персонаж погиб: ${state.reason}")
    }
}

fun main() {
    val character = GameCharacter("Алукард")

    character.changeState(Running)
    handleState(character.state)

    character.changeState(Attacking(20))
    handleState(character.state)

    character.changeState(Dead("утонул в луже"))
    handleState(character.state)
}