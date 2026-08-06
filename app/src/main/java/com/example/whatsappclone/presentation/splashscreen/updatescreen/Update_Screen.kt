package com.example.whatsappclone.presentation.splashscreen.updatescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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

fun updateScreen(){

    val scrollState= rememberScrollState()

    val sampleStatus = listOf(
        statusdata(image=R.drawable.disha_patani,name="disha patani",time="10 min ago"),
        statusdata(image=R.drawable.ajay_devgn,name="ajay devagan",time="20 min ago"),
        statusdata(image=R.drawable.akshay_kumar,name="akshay kumar",time="1 min ago")


    )

    val sampleChannel= listOf(
        Channels(image = R.drawable.neat_roots, name="Neat Roots", description = "latest news in tech"),
        Channels(image = R.drawable.img, name="Food Lover", description = "Discover new Records")

    )

    Scaffold(
        floatingActionButton = {

            FloatingActionButton(
                onClick ={ },
                containerColor = colorResource(id= R.color.light_green),
                modifier = Modifier.size(65.dp),
                contentColor = Color.White

            ) {
                Icon(painter = painterResource(id=R.drawable.baseline_photo_camera_24),contentDescription = null)
            }
        },
        bottomBar = {
            BottomNavigation()
        },
        topBar = {

            TopBar()
        }
    ) {

        Column (modifier = Modifier.padding(it).fillMaxSize().verticalScroll(scrollState)) {

            Text(
                text = "Status",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )

            MyStatus()

            sampleStatus.forEach { data ->


                StatusItem(statusdata = data)
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(
                color = Color.Gray
            )

            Text(
                text="Channels",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)

            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {

                Text(text="stays updated on topics that matter to you. Find channelsto follow")

                Spacer(modifier = Modifier.height(32.dp))
                Text(text="Find Channels to follow")
            }
            Spacer(modifier = Modifier.height(16.dp))

            sampleChannel.forEach{
                ChannelDesignItem(it)
            }



        }


    }



}

