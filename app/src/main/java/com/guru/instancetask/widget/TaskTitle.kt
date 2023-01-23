package com.guru.instancetask

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guru.instancetask.ui.theme.field_placeholder_big
import com.guru.instancetask.viewmodel.AddOrEditTaskViewModel

@Composable
fun TaskTitle(vm: AddOrEditTaskViewModel = viewModel()) {
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = vm.title.value,
        onValueChange = {
            vm.onTitleChange(it)
        },
        placeholder = {
            Text(
                stringResource(id = R.string.new_task_title_placeholder),
                style = field_placeholder_big
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent
        ),
        textStyle = field_placeholder_big,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences
        )
    )
}