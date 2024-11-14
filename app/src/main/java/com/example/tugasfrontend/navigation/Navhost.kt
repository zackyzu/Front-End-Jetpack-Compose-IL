package com.example.tugasfrontend.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasfrontend.HalamanList
import com.example.tugasfrontend.HalamanDetail
import com.example.tugasfrontend.HalamanAbout

@Composable
fun NavHost( navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(
        navController = navController,
        startDestination = Routes.HALAMAN_LIST,
        modifier = modifier
    ) {
        composable(Routes.HALAMAN_LIST) {
            HalamanList(navController)
        }

        composable(Routes.HALAMAN_DETAIL) {
            HalamanDetail(navController)
        }

        composable(Routes.HALAMAN_ABOUT) {
            HalamanAbout(navController)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewNavHost() {
    NavHost(navController = rememberNavController())
}