package gameCharacter

sealed class CharacterState

object Inactive : CharacterState()
object Running : CharacterState()

data class Attacking(val damage: Int) : CharacterState()
data class Dead(val  reason: String) : CharacterState()