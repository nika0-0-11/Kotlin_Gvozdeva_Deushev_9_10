package gameCharacter

class GameCharacter(val name: String) {
    var state: CharacterState = Inactive

    fun changeState(newState: CharacterState) {
        state = newState
    }
}