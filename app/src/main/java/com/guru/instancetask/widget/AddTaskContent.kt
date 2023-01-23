package com.guru.instancetask.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guru.instancetask.*
import com.guru.instancetask.R
import com.guru.instancetask.ui.theme.checkable_header
import com.guru.instancetask.utils.spaceY
import com.guru.instancetask.viewmodel.AddOrEditTaskViewModel

@Composable
fun AddTaskContent(
    vm: AddOrEditTaskViewModel = viewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(24.dp)
        ){
            item(){
                TaskTitle()
            }
            item{
                24.spaceY()
            }
            item(){
                TaskDescription()
            }
            item{
                24.spaceY()
            }
            item{
                TaskDateTime()
            }
            item{
                24.spaceY()
            }
            item{
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        stringResource(id = R.string.checklist),
                        style = checkable_header,
                        color = MaterialTheme.colors.primary
                    )
                }
            }
            if(vm.checkables.size==0){
                item{
                    TaskAddCheckable()
                }
            }
            else{
                items(
                    items = vm.checkables,
                    key = {
                        it.uid
                    }
                ){
                    CheckableItem(it)
                }
                item{
                    Spacer(
                        modifier = Modifier.height(60.dp)
                    )
                }
            }
        }
    }
}


