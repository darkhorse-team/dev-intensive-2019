package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts : List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)?.let { if(it!!.isEmpty()) null else it }
        val lastName = parts?.getOrNull(1)?.let { if (it!!.isEmpty()) null else it }
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val trmap = mapOf(
        "а" to "a", "б" to "b", "в" to "v", "г" to "g", "д" to "d", "е" to "e", "ё" to "e", "ж" to "zh",
        "з" to "z","и" to "i","й" to "i","к" to "k","л" to "l","м" to "m","н" to "n","о" to "o","п" to "p","р" to "r",
        "с" to "s", "т" to "t", "у" to "u", "ф" to "f", "х" to "h", "ц" to "c", "ч" to "ch",
        "ш" to "sh", "щ" to "sh'", "ъ" to "", "ы" to "i","ь" to "","э" to "e","ю" to "yu","я" to "ya", " " to divider)
        var trans = mutableListOf<String>()
        for (elem in payload) {
            if (elem.isUpperCase()) {
                val res = trmap.get(elem.toLowerCase().toString())
                if (res == null) {
                    trans.add(elem.toString())
                } else {
                    trans.add(res.capitalize())
                }
            } else {
                val res = trmap.get(elem.toString())
                if (res == null) {
                    trans.add(elem.toString())
                } else {
                    trans.add(res)
                }
            }
        }
        return trans.joinToString("")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials = mutableListOf<String>()
        val firstIndex = firstName?.trim()?.getOrNull(0)?.toUpperCase()?.let { initials.add(it.toString())}
        val secondIndex = lastName?.trim()?.getOrNull(0)?.toUpperCase()?.let { initials.add(it.toString())}

        return if(initials.size > 0) initials.joinToString("") else null

    }
}