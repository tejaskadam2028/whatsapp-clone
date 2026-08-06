package com.example.whatsappclone.presentation.splashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsappclone.presentation.splashscreen.HomeScreen.HomeScreen
import com.example.whatsappclone.presentation.splashscreen.callscreen.CallScreen
import com.example.whatsappclone.presentation.splashscreen.communities.CommunitesScreen
import com.example.whatsappclone.presentation.splashscreen.present.SplashScreen
import com.example.whatsappclone.presentation.splashscreen.updatescreen.updateScreen
import com.example.whatsappclone.presentation.splashscreen.userregistrationscreen.UserRegistrationScreen
import com.example.whatsappclone.presentation.splashscreen.welcomescreen.welcomeScreen

@Composable

fun WhatsAppNavigationSystem(){

    val navController= rememberNavController()

    NavHost(startDestination = Routes.SplashScreen, navController = navController){



        composable<Routes.SplashScreen>{
            SplashScreen(navController)
        }

        composable<Routes.WelcomeScreen>{
            welcomeScreen(navController)

        }


        composable<Routes.UserRegistrationScreen>{
            UserRegistrationScreen(navController)

        }



        composable<Routes.HomeScreen> {
            HomeScreen()

        }
        composable<Routes.UpdateScreen>{
            updateScreen()
        }

        composable<Routes.CallScreen>{
            CallScreen()
        }

        composable<Routes.CommunitiesScreen>{
            CommunitesScreen()
        }



    }



}