/*
 * Copyright (c) Funworld
 */

package com.funworld.mvvm_architecture.extension

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.YearMonth
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

const val JP_DATE_FORMAT: String = "yyyy年MM月dd日"
const val JP_DATE_TIME_FORMAT: String = "yyyy年MM月dd日 HH:mm"
const val SIMPLE_DATE_FORMAT: String = "yyyy-MM-dd"
const val SIMPLE_DATE_FORMAT_2: String = "MM-dd-yyyy"
const val SIMPLE_DATE_FORMAT_3: String = "yyyy/MM/dd"
const val JP_YEAR_MONTH_FORMAT: String = "yyyy年MM月"
const val SIMPLE_DATE_FORMAT_TIME: String = "yyyy-MM-dd HH:mm"
const val TIME_FORMAT: String = "HH:mm"
const val FULL_TIME_FORMAT = "HH:mm:ss"
const val FULL_TIME_FORMAT_1_24 = "kk:mm:ss"
const val TIME_FORMAT_1_24 = "kk:mm"
const val JP_DATE_FORMAT_WITH_WEEKDAY: String = "yyyy年MM月dd日 (E)"

fun Long.toLocalDate(): LocalDate {
    return Instant.ofEpochSecond(this).atZone(ZoneId.systemDefault()).toLocalDate()
}

fun String.toLocalDate(pattern: String = SIMPLE_DATE_FORMAT): LocalDate? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(pattern, Locale.JAPAN)
        LocalDate.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

fun String.toYearMonth(pattern: String = JP_YEAR_MONTH_FORMAT): YearMonth? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(pattern, Locale.JAPAN)
        YearMonth.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

fun String.toLocalDateTime(pattern: String = SIMPLE_DATE_FORMAT_TIME): LocalDateTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(pattern, Locale.JAPAN)
        LocalDateTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

fun String.toLocalTime(pattern: String = TIME_FORMAT): LocalTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(pattern, Locale.JAPAN)
        LocalTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

fun LocalDate.formatByPattern(pattern: String): String {
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.JAPAN)
    return this.format(formatter)
}

fun LocalDate.toEpochMilliSeconds(): Long {
    return atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}

fun Long.toLocalDateTime(): LocalDateTime {
    return Instant.ofEpochSecond(this).atZone(ZoneId.systemDefault()).toLocalDateTime()
}

fun LocalDateTime.formatByPattern(pattern: String): String {
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.JAPAN)
    return this.format(formatter)
}

fun LocalDate.inRange(start: LocalDate, end: LocalDate): Boolean {
    return this.isBefore(start).not() && this.isAfter(end).not()
}

fun daysBetween(start: LocalDate, end: LocalDate): Int {
    return ChronoUnit.DAYS.between(start, end).toInt()
}

fun LocalDate.equalOrBefore(date: LocalDate) = this.isAfter(date).not()

fun LocalDate.equalOrAfter(date: LocalDate) = this.isBefore(date).not()

fun LocalTime.isEqualOrAfter(other: LocalTime) = this.isBefore(other).not()

fun LocalTime.isEqualOrBefore(other: LocalTime) = this.isAfter(other).not()

fun LocalDateTime.isEqualOrAfter(other: LocalDateTime) = this.isBefore(other).not()

fun LocalDateTime.isEqualOrBefore(other: LocalDateTime) = this.isAfter(other).not()
