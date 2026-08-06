package com.example.whatsappclone.presentation.splashscreen.profile

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.whatsappclone.R
import com.example.whatsappclone.presentation.splashscreen.viewmodel.PhoneAuthViewModel
import com.google.firebase.auth.auth
import com.google.firebase.Firebase

@Composable
fun userProfileSetScreen(
    phoneAuthViewModel: PhoneAuthViewModel,
    navHostController: NavHostController
) {

    var name by remember {
        mutableStateOf("")
    }

    var status by remember {
        mutableStateOf("")
    }

    var profileImage by remember {
        mutableStateOf<Uri?>(null)
    }

    var bitmapImage by remember {
        mutableStateOf<Bitmap?>(null)
    }

    val firebaseAuth = Firebase.auth

    val phoneNumber = firebaseAuth.currentUser?.phoneNumber ?: ""
    val userId = firebaseAuth.currentUser?.uid ?: ""

    val context = LocalContext.current

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->

            // Save selected image URI
            profileImage = uri

            uri?.let {
                bitmapImage =
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {

                        @Suppress("DEPRECATION")
                        android.provider.MediaStore.Images.Media.getBitmap(
                            context.contentResolver,
                            it
                        )
                    } else {
                        val source =
                            ImageDecoder.createSource(context.contentResolver, it)
                        ImageDecoder.decodeBitmap(source)
                    }
            }
        }
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = CircleShape
                )
                .clickable {
                    imagePickerLauncher.launch("image/*")
                }
        ) {

            if (bitmapImage != null) {

                Image(
                    bitmap = bitmapImage!!.asImageBitmap(),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

            } else {

                Image(
                    painter = painterResource(id = R.drawable.placeholderimg),
                    contentDescription = "Placeholder",
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}