package com.guru.instancetask.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guru.instancetask.data.Task
import com.guru.instancetask.ui.theme.GreenColor
import com.guru.instancetask.ui.theme.LightRedColor
import com.guru.instancetask.ui.theme.LightSkyColor
import com.guru.instancetask.ui.theme.task_title_style
import com.guru.instancetask.utils.date
import com.guru.instancetask.utils.format12Hour
import com.guru.instancetask.utils.spaceY
import com.guru.instancetask.utils.time
import com.guru.instancetask.viewmodel.HomeViewModel

@Composable
fun TaskItem(
    task: Task,
    vm: HomeViewModel = viewModel()
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    task.title,
                    style = task_title_style,
                    modifier = Modifier.fillMaxWidth().weight(1f)
                )
                TaskActions(task)
            }
            if(task.description.isNotEmpty()||task.dueDateTime.isNotEmpty()||task.checkables.size>0){
                8.spaceY()
                Divider()
            }
            if(task.description.isNotEmpty()){
                8.spaceY()
                Text(
                    task.description
                )
            }
            if(task.dueDateTime.isNotEmpty()){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        task.dueDateTime.date,
                    )
                    Text(
                        task.dueDateTime.time.format12Hour,
                    )
                }
            }
            task.checkables.forEach {checkable->
                checkable?.let {
                    CheckableDisplayItem(task,it)
                }
            }
        }
    }
}

@Composable
fun TaskActions(
    task: Task,
    vm: HomeViewModel = viewModel()
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        IconButton(
            onClick = {
                vm.markTaskDone(task)
            },
            modifier = Modifier.size(24.dp)
        ) {
            if(task.done){
                Icon(
                    imageVector = Icons.Default.DoneAll,
                    contentDescription = "Done",
                )
            }
            else{
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Done",
                    tint = GreenColor
                )
            }
        }
        IconButton(
            onClick = {
                vm.editTask(task)
            },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                tint = LightSkyColor
            )
        }
        IconButton(
            onClick = {
                vm.deleteTask(task)
            },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = LightRedColor
            )
        }
    }
}
