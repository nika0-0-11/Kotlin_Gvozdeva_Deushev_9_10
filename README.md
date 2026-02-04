# Лабораторная работа №9-10. Продвинутое ООП

---

## Описание

Лабораторная работа посвящена изучению продвинутых концепций ООП о программирование в Kotlin.

---

## Структура проекта 

Проект содержит примеры реализации продвинутых механизвом ООП, а также пояснение к ключевым концепциям.

---

## Как запустить проект 

1. Клонируйте репозиторий:

```bash
    git clone <URL_репозитория>
```
2. Откройте проект в Intellij IDEA.
3. Запустите любой пример через контекстное меню или напрямую из `main`.

---

## Изученные темы

### Геттеры и сеттеры

**Геттеры** и **сеттеры** в Kotlin позволяют контролировать доступ к свойствам класса, добавляя валидацию, логирование и динамические вычисления.

**Пример:**

```kotlin
class Hero(val name: String) {
    var health: Int = 100
        set(value) {
            field = value.coerceIn(0, 100)
        }
    
    val stamina: Int
        get() = 50 + (health / 10)
    }
```

---

### Инкапсуляция 

Инкапсуляция скрывает внутреннее состояние объекта и защищает данные от некорректного изменения с помощью модификаторов доступа и костомных аксессоров.

**Пример:**

```kotlin
class OutpostWorker(val name: String) {
    var energy: Int = 100
        set(value) {
            field = value.coerceIn(0, maxEnergy)
        }
    private var maxEnergy = 100
    var level: Int = 1
        private set
} 
```

---

### Data-классы

Data-классы предназначены для хранения данных и автоматически генерируют методы.

**Пример:**

```kotlin
data class OutpostResource(
    val id: Int,
    val name: String,
    var amount: Int
) {
    override fun toString(): String {
        return "Ваш ресурс: $id | Имя: $name | Количество: $amount"
    }
}
```

---

### Абстрактные классы

Абстрактные классы используются для описания общей логики и структуры группы связанных классов. Они могут содержать как абстрактные, так и реализованные методы.

**Пример:**

```kotlin
abstract class OutpostModule(val name: String, var level: Int = 1) {
    fun upgrade() {
        level++
        println("$name повышен до уровня: $level")
    }
}
```

---

### Интерфейсы 

Интерфейсы представляют контракт поведения, который класс обязуется реализовать. Они могут содержать методы с реализацией по умолчанию и свойства.

**Пример:**

```kotlin
interface ModuleAction {
    fun execute(manager: ResourceManager)
}
```

---

# Лабораторная работа №11. Sealed-классы и моделирование состояний

## Galaxy Outpost Manager

Учебный проект на Kotlin, демонстрирующий основы объектно-ориентированного программированияиархитектурные приёмы языка. 

---

### Sealed-классы

**Sealed-классы** используются для представления ограниченного набора состояний или результатов, которыеизвестны на этапе компиляции. 

Они позволяют:
- гарантировать обработку всех возможных вариантов;
- безопасно использовать конструкцию when без else;
- удобно описывать состояния, события и результаты действий. 

### Пример: результат работы модуля

```kotlin
sealed-class ModuleResult {
    data class Success(val message: String) : ModuleResult()
    data class ResourceProduced(val resourceName: String, val amount: Int) : ModuleResult()
    data class NotEnoughResources(
        val resourceName: String, 
        val required: Int, 
        val available: Int
    ) : ModuleResult()
    data class Error(val reason: String) : ModuleResult()
}
```

### Object в Kotlin

**object** — это специальная конструкция Kotlin, которая создаёт единственный экземпляр класса (Singleton).

Особенности:
- создаётся при первом обращении;
- существует в одном экземпляре;
- не имеет конструктора. 

### Пример: глобальный логгер

```kotlin
object Logger {
private var counter = 0

    fun log(message: String) {
        counter++
        println("[$counter] $message")
    }
}
```

### Использование:

```kotlin
Logger.log("Инициализация системы")
Logger.log("Модуль запущен")
```

**object** удобно использовать для:
- логгеров;
- конфигураций;
- состояний без данных в sealed-классах;
- утилитарных классов

---