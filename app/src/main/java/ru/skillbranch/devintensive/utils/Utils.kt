package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return when (fullName) {
            null -> null to null
            " " -> null to null
            "" -> null to null
            firstName -> {
                firstName to null
            }

            else -> firstName to lastName
        }
    }

    fun transliteration(payload: String, divider: String = " "):String{
        val parts: List<String>? = payload.split(" ","_")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        val cyr:MutableList<Char> = mutableListOf('а', 'б','в', 'г', 'д', 'е', 'ё', 'ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я')
        val lat:MutableList<String> = mutableListOf("a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "c", "ch", "sh", "sh'", "", "i", "", "e", "yu", "ya")
        val builder: StringBuilder? = null
        for (i in payload)
            for (j in cyr)
                if (payload[i.toInt()] == cyr[j.toInt()]){
                    builder?.append(lat[j.toInt()])
                }
        return builder.toString()

}

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstInitial = firstName?.get(0).toString()
        val secondInitial = lastName?.get(0).toString()

        return "$firstInitial$secondInitial"

    }
}