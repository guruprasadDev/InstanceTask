package com.guru.instancetask.datetime.date

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.guru.instancetask.datetime.date.DatePickerColors
import java.time.LocalDate

internal class DatePickerState(
    initialDate: LocalDate,
    val colors: DatePickerColors,
    val yearRange: IntRange,
    val dialogBackground: Color
) {
    var selected by mutableStateOf(initialDate)
    var yearPickerShowing by mutableStateOf(false)
}
