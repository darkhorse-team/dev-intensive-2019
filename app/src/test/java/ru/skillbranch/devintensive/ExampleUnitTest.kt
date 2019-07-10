package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Cena")
    }



    @Test
    fun test_factory() {
//        val user = User.makeUser("John Cena")
        val user = User.makeUser("John Wick")
        val user2 = user.copy(id="2", lastName = "Cena", lastVisit = Date())
        println("$user \n$user2")


//        val user3 = User.makeUser("John Silverhand")
//        val user4 = User.makeUser("")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user


        val (id, firstName, lastName) = getUserInfo()

        println("$id $firstName $lastName")

        println("${user.component1()} ${user.component2()} ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("Jogn Wick")
        var user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))


//        user2 = user
//        if(user == user2) {
//            println("equal ${user.hashCode()} $user \n${user2.hashCode()} $user2")
//        } else {
//            println("not equals ${user.hashCode()} $user \n" +
//                    "${user2.hashCode()} $user2")
//        }
//
//
//        if(user === user2) {
//            println("equal links ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        } else {
//            println("not equals links ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        }
        var user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())

    }

    @Test
    fun test_data_mapping() {
        val user = User.makeUser("Исхаков Наиль")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))

        val userView = newUser.toUserView()

        println(user)

        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user= User.makeUser("Исхаков Наиль")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type="text")
        val imageMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type="image")

//        when(imageMessage) {
//            is TextMessage -> println("this is text message")
//            is ImageMessage -> println("this is image message")
//            is BaseMessage -> println("this is base message")
//        }

        println(txtMessage.formatMessage())
        println(imageMessage.formatMessage())
    }

    @Test
    fun test_parseFullName() {
        println(Utils.parseFullName(null)) //null null
        println(Utils.parseFullName("")) //null null
        println(Utils.parseFullName(" ")) //null null
        println(Utils.parseFullName("John"))//John null
    }

    @Test
    fun test_date_format_extension() {
        println(Date().format()) //14:00:00 27.06.19
        println(Date().format("HH:mm")) //14:00
    }

    @Test
    fun test_date_add_extension() {
        println(Date().add(2, TimeUnits.SECOND)) //Thu Jun 27 14:00:02 GST 2019
        println(Date().add(-4, TimeUnits.DAY)) //Thu Jun 23 14:00:00 GST 2019
    }

    @Test
    fun test_toinitials() {
        println(Utils.toInitials("john" ,"doe")) //JD
        println(Utils.toInitials("John", null)) //J
        println(Utils.toInitials(null, null)) //null
        println(Utils.toInitials(" ", "")) //null
    }

    @Test
    fun test_transliteration() {
        println(Utils.transliteration("Женя Стереотипов")) //Zhenya Stereotipov
        println(Utils.transliteration("Amazing Петр","_"))//Amazing_Petr
    }

}
