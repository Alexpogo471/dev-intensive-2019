package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView {

    val nickname ="$firstName $lastName"
    val initials = Utils.toInitials(firstName, lastName)
    val status =
        if (lastVisit == null) "Еще ни разуне был" else if (isOnline) "online"
        else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickname,
        initials = initials,
        status = status
    )
}

fun Date.humanizeDiff(date: Date = Date()): String {

    val result = date.time - this.time

    val seconds = result / 1000
    val minute = result / 60000
    val hour = result / 3600000
    val day = result / 86400000
    return when (seconds) {
        in 0..2 -> "только что"
        in 3..45 -> "несколько секунд назад"
        in 46..75 -> "минуту назад"
        in 76..2700 -> "$minute ${validateMinute(minute)} назад"
        in 2701..4500 -> "час назад"
        in 4501..79200 -> "$hour ${validateHour(hour)} назад"
        in 79201..93600 -> "день назад"
        in 93601..31536000 -> "$day ${validateDay(day)} назад"
        else -> "более года назад"
    }
}

fun validateMinute(minute:Long): String {
    return when{
        minute%10L == 1L -> "минуту"
        minute%10L in 2L..4L -> "минуты"
        else -> "минут"
    }
}

fun validateHour(hour:Long): String {
    return when{
        hour%10L == 1L -> "час"
        hour%10L in 2L..4L -> "часа"
        else -> "часов"
    }
}

fun validateDay(day:Long): String {
    return when{
        day%10L == 1L -> "день"
        day%10L in 2L..4L -> "дня"
        else -> "дней"
    }
}
