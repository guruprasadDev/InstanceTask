package com.guru.instancetask.widget
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guru.instancetask.R
import com.guru.instancetask.ui.theme.LightRedColor
import com.guru.instancetask.ui.theme.dialog_message_style
import com.guru.instancetask.ui.theme.delete_dialog_title_style
import com.guru.instancetask.utils.spaceX
import com.guru.instancetask.utils.spaceY
import com.guru.instancetask.viewmodel.HomeViewModel

@Composable
fun AskTaskDelete(
    vm: HomeViewModel = viewModel()
) {
    Dialog(
        onDismissRequest = {
            vm.onAskTaskDeleteCancel()
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    stringResource(id = R.string.delete_task),
                    style = delete_dialog_title_style,
                )
                12.spaceY()
                Divider()
                12.spaceY()
                Text(
                    stringResource(id = R.string.are_you_sure_to_delete),
                    style = dialog_message_style
                )
                12.spaceY()
                Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Button(
                        onClick = {
                            vm.confirmDeleteTask()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = LightRedColor,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth().weight(1f)
                    ) {
                        Text(stringResource(id = R.string.yes))
                    }
                    12.spaceX()
                    Button(
                        onClick = {
                            vm.onAskTaskDeleteCancel()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = LightRedColor
                        ),
                        modifier = Modifier.fillMaxWidth().weight(1f)
                    ) {
                        Text(stringResource(id = R.string.no))
                    }
                }
            }
        }
    }
}