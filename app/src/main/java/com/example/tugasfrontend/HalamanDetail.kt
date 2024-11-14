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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.example.tugasfrontend.ui.theme.component.TopBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasfrontend.ui.theme.TugasfrontendTheme

@Composable
fun HalamanDetail(navController: NavController, modifier: Modifier = Modifier) {

    Scaffold(
        modifier = modifier,
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(colorResource(id = R.color.ireng))
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp) // Tinggi Card
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image2),
                        contentDescription = "Transformers One Poster",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    TopBar(
                        title = "Detail Film",
                        navController = navController,
                        modifier = Modifier
                            .padding(start = 24.dp)
                    )

                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(horizontal = 18.dp)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Transformers One",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.white)
                        )
                        Text(
                            text = "Witness The Origin",
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.white)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 35.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Sinopsis Film",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.white)
                    )

                    Text(
                        text = "Film ini menceritakan salah satu sejarah penting di Cybertron, planet para robot Transformers. Sejarah ini melibatkan dua pekerja Cybertronian bernama Orion Pax (Chris Hemsworth) dan D-16 (Brian Tyree Henry). Ketika dunia mereka sedang kacau, mereka adalah sepasang sahabat yang selalu bersama. Orion Pax dan D-16 menghabiskan waktu bekerja sebagai penguat keamanan Cybertron, hingga sesuatu yang sebenarnya terjadi.",
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.white),
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Ayo, Tonton Filmnya di Bioskop Terdekat!!",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.white)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HalamanDetailtPreview() {
    TugasfrontendTheme {
        HalamanDetail(
            navController = rememberNavController(),
            modifier = Modifier
        )
    }
}