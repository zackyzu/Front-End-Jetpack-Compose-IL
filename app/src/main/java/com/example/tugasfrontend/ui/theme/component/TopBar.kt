package com.example.tugasfrontend.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasfrontend.R

@Composable
fun TopBar(title: String, navController: NavController, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.CenterStart)

        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterStart)
            )
        }
        Spacer(modifier = Modifier.width(45.dp))
        Text(
            text = title,
            fontSize = 18.sp,
            lineHeight = 20.sp,
            letterSpacing = (-0.24).sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}
