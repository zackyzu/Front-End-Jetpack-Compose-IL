package com.example.tugasfrontend


import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.tugasfrontend.ui.theme.component.TopBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tugasfrontend.navigation.Routes
import com.example.tugasfrontend.ui.theme.TugasfrontendTheme

@Composable
fun HalamanList(navController: NavHostController, modifier: Modifier = Modifier) {
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
                    .padding(horizontal = 35.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 21.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "List Film",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.white),
                    )

                    IconButton(onClick = {navController.navigate(Routes.HALAMAN_ABOUT)}) {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Bookmark",
                            tint = colorResource(id = R.color.white),
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }

                SearchBarListFilm()
                Text(
                    text = "Kategori",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.padding(top = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                Kategori()

                Text(
                    text = "Rekomendasi",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.padding(top = 24.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                Rekomendasi(navController = navController)


                Text(
                    text = "Film Terkini",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.padding(top = 24.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                FilmTerkini(navController = navController)

                LazyColumn(
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(10) {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun SearchBarListFilm() {
    Card(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .height(40.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding()
                .padding(start = 17.dp, bottom = 8.dp, top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier
                    .size( width = 25.dp, height = 25.dp),
                tint = colorResource(R.color.abu)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Cari Film",
                color = Color.Gray,
                fontSize = 12 .sp
            )
        }
    }
}


@Composable
fun Kategori() {
    val categories = listOf("Drama", "Aksi", "Horror", "Komedi", "Sci-Fi", "Fantasi","Animasi","Dokumenter","Musical","Thriller")
    var selectedCategory by remember { mutableStateOf(categories[0]) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        categories.forEach { category ->
            Box(
                modifier = Modifier
                    .background(
                        color = if (category == selectedCategory) colorResource(R.color.biru)
                        else colorResource(R.color.white),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .clickable { selectedCategory = category }
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Text(
                    text = category,
                    color = if (category == selectedCategory) colorResource(R.color.black)
                    else colorResource(R.color.abu),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 20.sp,
                    letterSpacing = (-0.24).sp
                )
            }
        }
    }
}

@Composable
fun Rekomendasi(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        val totalItems = 10
        val itemsPerGroup = 4
        val numberOfGroups = (totalItems + itemsPerGroup - 1) / itemsPerGroup

        items(numberOfGroups) { groupIndex ->
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.width(320.dp)
            ) {

                val rowCount = (itemsPerGroup + 1) / 2

                repeat(rowCount) { rowIndex ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        repeat(2) { columnIndex ->
                            val itemIndex = groupIndex * itemsPerGroup + rowIndex * 2 + columnIndex


                            if (itemIndex < totalItems) {
                                Card(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(150.dp)
                                        .clickable { },
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .aspectRatio(1f)
                                    ) {
                                        val imageResId = when (itemIndex % 5) {
                                            0 -> R.drawable.drama_film
                                            1 -> R.drawable.comedy_film
                                            2 -> R.drawable.horror_film
                                            3 -> R.drawable.action
                                            else -> R.drawable.drama_film
                                        }

                                        Image(
                                            painter = painterResource(id = imageResId),
                                            contentDescription = "Film ${itemIndex + 1}",
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .clickable(
                                                    enabled = (itemIndex % 5 == 3),  // Hanya aktif untuk action
                                                    onClick = {
                                                        if (itemIndex % 5 == 3) {
                                                            navController.navigate(Routes.HALAMAN_DETAIL)
                                                        }
                                                    }
                                                ),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FilmTerkini(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(10) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clickable { },
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(16f/9f)
                ) {
                    val imageResId = when (index % 5) {
                        0 -> R.drawable.image2
                        1 -> R.drawable.image
                        2 -> R.drawable.image2
                        3 -> R.drawable.image
                        else -> R.drawable.image
                    }

                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = "Image ${index + 1}",
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(
                                enabled = (index % 5 == 0),  // Hanya aktif untuk image2
                                onClick = {
                                    if (index % 5 == 0) {
                                        navController.navigate(Routes.HALAMAN_DETAIL)
                                    }
                                }
                            ),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HalamanListPreview() {
    TugasfrontendTheme {
        HalamanList(
            navController = rememberNavController(),
            modifier = Modifier)
    }
}


