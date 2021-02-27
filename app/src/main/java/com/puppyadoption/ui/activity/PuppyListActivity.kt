package com.puppyadoption.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puppyadoption.ui.data.Puppy
import com.puppyadoption.ui.theme.MyAppTheme
import com.puppyadoption.ui.theme.transparent
import com.puppyadoption.ui.utils.getPuppyList
import dev.chrisbanes.accompanist.coil.CoilImage

class PuppyListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                PuppyList(getPuppyList()) {
                    startActivity(Intent(this,PuppyDetailActivity::class.java)
                        .putExtra("puppy",it))
                }
            }
        }
    }
}

@Composable
fun PuppyList(puppies: List<Puppy>,
                    onItemClicked: (puppy: Puppy) -> Unit) {
    Column(modifier = Modifier.background(color = Color.White)) {
        Text(
            text = "\uD83D\uDC36  Awesome Puppies  \uD83D\uDC3E ",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp),
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        )
        LazyColumn(
            content = {
                items(puppies) { puppy ->
                    PuppyItem(
                        puppy = puppy,
                    ){
                        onItemClicked(puppy)
                    }
                }
            }

        )
    }
}

@Composable
private fun PuppyItem(puppy: Puppy, onclick:(puppy: Puppy)->Unit) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 3.dp, bottom = 15.dp)
                .fillMaxWidth()
                .wrapContentHeight()

        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clickable(
                        onClick = {
                            onclick(puppy)
                        }
                    ),
                elevation = 10.dp,
                contentColor = Color.White


            ) {
                CoilImage(
                    data = puppy.image,
                    contentDescription = "Android Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )
                Image(
                    ColorPainter(transparent),
                    contentDescription = "description of the image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                )
                Column(
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = puppy.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
                        style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 23.sp,
                        )
                    )
                    Text(
                        text = "Age : "+puppy.ageInMonth.toString()+" Months old",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
                        style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                        )
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyAppTheme {
        PuppyList(getPuppyList()) {

        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyAppTheme(darkTheme = true) {
        PuppyList(getPuppyList()) {

        }
    }
}
