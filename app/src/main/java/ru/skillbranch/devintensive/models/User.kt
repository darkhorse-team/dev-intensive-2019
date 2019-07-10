package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    var introBit : String = "tu tu tu tuubit!!"

    constructor(id: String) : this(
        id,
        "John",
        "Doe"
    )

    init {

        introBit = getIntro()

        println("It's alive!! ${if(lastName === "Doe") "His name is $firstName $lastName" else "And his mname is $firstName $lastName"}")
                // "${getIntro()}"

    }

    private fun getIntro() = """
        tu tu tu ttuuuuuu!!
        tu tu tu tuuu!! ...

        tu tu tu ttuuuuuu!!
        tu tu tu tuuu!! ...

        ${"\n"}\n

        $firstName $lastName
    """.trimIndent()

    fun printMe() = println("""
            id: $id
            firstName: $firstName
            lastName: $lastName
            avatar: $avatar
            rating: $rating
            respect: $respect
            lastVisit: $lastVisit
            isOnline: $isOnline
        """.trimIndent())

    companion object Factory {
        private var lastId : Int = -1

        fun makeUser(fullName: String?) : User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }
}