package example

interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop() {
        println("Останавливаемся...")
    }
}

interface Worker {
    fun work()
}

interface Student {
    fun study()
}

interface VideoPlayable {
    fun play() = println("Play video")
}
interface AudioPlayable {
    fun play() = println("Play audio")
}

class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()

    }
}

class Car(
    override val model: String,
    override val number: String
) : Movable {
    override var speed = 60
    override fun move() {
        println("Едем на машине со скоростью $speed км/ч")
    }
}

class Aircraft(
    override val model: String,
    override val number: String
) : Movable {
    override var speed = 600
    override fun move() {
        println("Летим на самолете со скоростью $speed км/ч")
    }

    override fun stop() = println("Приземляемся...")
}

class WorkingStudent(val name: String) : Worker, Student {
    override fun work() = println("$name работает")
    override fun study() = println("$name учится")
}

fun travel(obj: Movable) = obj.move()

fun main() {
    /*val car: example.Movable = example.Car("BMW", "123BMW")
    val aircraft: example.Movable = example.Aircraft("Boeing", "737")
    example.travel(car)
    example.travel(aircraft)
    aircraft.move()
    aircraft.stop()

    val pavel = example.WorkingStudent("Pavel")
    pavel.work()
    pavel.study()*/

    val player = MediaPlayer()
    player.play()
}