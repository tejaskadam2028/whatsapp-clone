package com.example.whatsappclone.presentation.splashscreen.callscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R
import com.example.whatsappclone.presentation.splashscreen.bottomnavigation.BottomNavigation

@Composable
@Preview(showSystemUi = true)

fun CallScreen() {

    val samplecall= listOf(
        call(image = R.drawable.bhuvan_bam, name = "Bhuvan bam", time = "Yesterday, 6.00 Am", isMissed = true),
        call(image = R.drawable.sharadha_kapoor, name = "Sharadha Kapoor", time = "Monday, 1.00 Pm", isMissed = false),
        call(image = R.drawable.tripti_dimri, name = "tripti dimri", time = "Yesterday, 12.00 Am", isMissed = false),
        call(image = R.drawable.sharukhkhan, name = "sharukh khan", time = "Yesterday, 3 Am", isMissed = true),
        call(image = R.drawable.sharadha_kapoor, name = "Sharadha Kapoor", time = "Monday, 1.00 Pm", isMissed = false),
        call(image = R.drawable.tripti_dimri, name = "tripti dimri", time = "Yesterday, 12.00 Am", isMissed = false),
        call(image = R.drawable.sharadha_kapoor, name = "Sharadha Kapoor", time = "Monday, 1.00 Pm", isMissed = false),

    )


    var isSearching by remember {
        mutableStateOf(false)
    }

    var search by remember {
        mutableStateOf("")
    }

    var showMenu by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {

            Box(modifier = Modifier.fillMaxWidth()) {

                Column {
                    Row {
                        if (isSearching) {
                            TextField(
                                value = search, onValueChange = {
                                    search = it
                                }, placeholder = {
                                    Text(text = "Search")
                                }, colors = TextFieldDefaults.colors(

                                    unfocusedContainerColor = Color.Transparent,
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent
                                ), modifier = Modifier.padding(start = 12.dp), singleLine = true
                            )
                        } else {
                            Text(
                                text = "Calls",
                                fontSize = 28.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 12.dp, top = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.weight(1f))
                        if (isSearching) {
                            IconButton(onClick = {
                                isSearching = false
                                search = ""

                            }) {

                                Icon(
                                    painter = painterResource(id = R.drawable.cross),
                                    contentDescription = null,
                                    modifier = Modifier.size(15.dp)
                                )
                            }

                        } else {

                            IconButton(onClick = { isSearching = true }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.search),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            IconButton(onClick = {
                                showMenu = true

                            }) {


                                Icon(
                                    painter = painterResource(id = R.drawable.more),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )

                                DropdownMenu(
                                    expanded = showMenu, onDismissRequest = { showMenu = false }) {

                                    DropdownMenuItem(
                                        text = { Text(text = "Setting") },
                                        onClick = { showMenu = false })


                                }
                            }

                        }
                    }
                    HorizontalDivider()

                }
            }
        },
        bottomBar = {
            BottomNavigation()
        },
        floatingActionButton = {

            FloatingActionButton(
                onClick ={ },
                containerColor = colorResource(id= R.color.light_green),
                modifier = Modifier.size(65.dp),
                contentColor = Color.White

            ) {
                Icon(painter = painterResource(id=R.drawable.add_call),contentDescription = null)
            }
        }

    )
    {
        Column(modifier = Modifier.padding(it)) {

            Spacer(modifier = Modifier.height(16.dp))

            fauoriteSection()

            Button(
                onClick = { },

                colors = ButtonDefaults.run { buttonColors(containerColor = colorResource(R.color.light_green)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Start a new call",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )


            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Recent Calls",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)


            )

            LazyColumn {
                items(samplecall){data ->
                    CallItemDesign(data)

                }
            }




        }
    }
}