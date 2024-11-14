package com.example.tugasfrontend

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.example.tugasfrontend.ui.theme.component.TopBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasfrontend.ui.theme.TugasfrontendTheme

@Composable
fun HalamanAbout(navController: NavController, modifier: Modifier = Modifier) {

    Scaffold(
        modifier = Modifier,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.ireng))
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 37.dp),
            verticalArrangement = Arrangement.Top
        ) {
            TopBar(
                title = "Profile",
                navController = navController
            )
            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(color = Color.Gray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = "Foto Profil",
                    modifier = Modifier.size(110.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Zulhida",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = "Zacky Ulchaq",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "zackyzulhida@gmail.com",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Universitas Telkom Purwokerto",
                fontSize = 16.sp,
                color = Color.Gray,
            )
            Text(
                text = "S1 Teknik Informatika",
                fontSize = 16.sp,
                color = Color.Gray,

                )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.line_1),
                contentDescription = "Pembatas",
                modifier = Modifier.size(width = 319.dp, height = 2.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(id = R.drawable.virtual_reality), // Replace with your graphic's resource ID
                contentDescription = "Graphic Bottom",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.FillWidth
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun HalamanAboutPreview() {
    TugasfrontendTheme {
        HalamanAbout(
            navController = rememberNavController(),
            modifier = Modifier
        )
    }
}

