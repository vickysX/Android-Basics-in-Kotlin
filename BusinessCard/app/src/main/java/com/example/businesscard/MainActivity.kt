package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Composition()
                }
            }
        }
    }
}

@Composable
fun MyName(name: String, title: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 38.dp, end = 38.dp)) {
        Image(painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier.height(90.dp))
        Text(text = name,
        fontSize = 45.sp,
        textAlign = TextAlign.Center,
        color = Color.White)
        Text(text = title,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = Color(0xFF3ddc84),
        fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Contact(iconId: Int, contact: String) {
    Divider(color = Color.LightGray,
        modifier = Modifier.fillMaxWidth())
    Row(modifier = Modifier
        .fillMaxWidth(1f)
        .padding(15.dp)) {
        Icon(painter = painterResource(id = iconId),
            tint = Color(0xFF3ddc84),
            contentDescription = null,
            modifier = Modifier.weight(0.10f))
        Spacer(modifier = Modifier.weight(0.15f))
        Text(text = contact,
            textAlign = TextAlign.Left,
            color = Color.White,
            modifier = Modifier.weight(0.65f))
    }
}

@Composable
fun MyContacts(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Contact(iconId = R.drawable.ic_telephone, contact = "+39 388 420 9178")
        Contact(iconId = R.drawable.ic_baseline_share_24, contact = "@AndroidDev")
        Contact(iconId = R.drawable.ic_baseline_email_24, contact = "v.sassu48@gmail.com")
    }
}

@Composable
fun Composition() {
    Column(modifier = Modifier
        .padding(start = 10.dp, end = 15.dp, top = 230.dp, bottom = 10.dp)
        .fillMaxHeight(1f)) {
        MyName(name = "Vittorio Sassu",
            title = "Associate Android Developer",
            modifier = Modifier.weight(0.33f))
        Spacer(modifier = Modifier.weight(0.33f))
        MyContacts(modifier = Modifier.weight(0.33f))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Surface(color = MaterialTheme.colors.background) {
            Composition()
        }

    }
}