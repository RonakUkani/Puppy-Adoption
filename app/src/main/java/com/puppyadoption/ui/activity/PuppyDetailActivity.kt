package com.puppyadoption.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puppyadoption.ui.data.Puppy
import com.puppyadoption.ui.theme.MyAppTheme
import com.puppyadoption.ui.theme.black
import com.puppyadoption.ui.theme.grey
import com.puppyadoption.ui.theme.light
import dev.chrisbanes.accompanist.coil.CoilImage

class PuppyDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                PuppyDetail(intent.getParcelableExtra("puppy")!!) {
                    onBackPressed()
                }
            }
        }
    }
}

@Composable
fun PuppyDetail(puppy: Puppy, backPress: () -> Unit) {
    MyAppTheme {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column {
                Row(
                    Modifier.padding(10.dp)
                ) {
                    CoilImage(
                        data = com.puppyadoption.R.drawable.ic_back_arrow,
                        contentDescription = "asdsad",
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp)
                            .clickable { backPress.invoke() },
                        alignment = Alignment.Center
                    )
                    Text(
                        text = puppy.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(end = 20.dp),
                        style = TextStyle(
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                }

                CoilImage(
                    data = puppy.image,
                    contentDescription = "Android Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(top = 5.dp),
                    contentScale = ContentScale.Crop
                )
                Row(

                    Modifier
                        .fillMaxWidth()
                        .requiredWidthIn(1.dp)
                        .padding(top = 15.dp)
                ) {
                    GetCard("Gender", puppy.gender)
                    GetCard("Age", "${puppy.ageInMonth} Months")
                    GetCard("Weight", "${puppy.weight} Kg")
                    GetCard("Color", puppy.color)
                }

                Spacer(
                    Modifier
                        .fillMaxWidth()
                        .height(11.dp)
                        .padding(start = 15.dp, end = 15.dp, top = 10.dp)
                        .background(black)
                )
                Text(
                    text = "About",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 10.dp, end = 10.dp),
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = black,
                        textAlign = TextAlign.Center
                    )


                )
                Text(
                    text = puppy.description,
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(start = 10.dp, bottom = 10.dp, end = 10.dp),
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp,
                        color = grey,
                        textAlign = TextAlign.Center
                    )
                )
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Card(
                        modifier = Modifier
                            .width(180.dp)
                            .height(45.dp)
                            .clickable(
                                onClick = {

                                }
                            ),
                        shape = RoundedCornerShape(
                          topStart =  15.dp,bottomStart = 15.dp),
                        elevation = 10.dp,
                        backgroundColor = light
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Adopt Me \uD83D\uDC3E",
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .wrapContentHeight(),
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp,
                                    color = black,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GetCard(label: String, value: String) {
    Box {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp),
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 17.sp,
                    color = black,
                    textAlign = TextAlign.Center
                )


            )
            Text(
                text = value,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp),
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    color = grey,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewDetails() {
    MyAppTheme {
        PuppyDetail(Puppy()) {

        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewDetails() {
    MyAppTheme {
        PuppyDetail(Puppy()) {
        }
    }
}
