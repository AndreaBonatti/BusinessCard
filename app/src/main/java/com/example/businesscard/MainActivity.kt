package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
                    TopSection(
                        R.drawable.android_logo,
                        stringResource(id = R.string.full_name),
                        stringResource(id = R.string.title)
                    )
                    BottomSection(
                        stringResource(id = R.string.phone),
                        stringResource(id = R.string.social),
                        stringResource(id = R.string.mail)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF003a4a)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopSection(
                R.drawable.android_logo,
                stringResource(id = R.string.full_name),
                stringResource(id = R.string.title),
                Modifier.weight(1f)
            )
            BottomSection(
                stringResource(id = R.string.phone),
                stringResource(id = R.string.social),
                stringResource(id = R.string.mail),
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )
        }
    }
}

@Composable
fun TopSection(imageResource: Int, fullName: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = fullName,
            color = Color.White,
            fontSize = 48.sp
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun TopSectionPreview() {
    BusinessCardTheme {
        TopSection(
            R.drawable.android_logo,
            stringResource(id = R.string.full_name),
            stringResource(id = R.string.title)
        )
    }
}

@Composable
fun BottomSection(phone: String, social: String, mail: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(48.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Divider(color = Color.White, thickness = 1.dp)
        TextLine(text = phone, imageVector = Icons.Filled.Phone)
        Divider(color = Color.White, thickness = 1.dp)
        TextLine(text = social, imageVector = Icons.Filled.Share)
        Divider(color = Color.White, thickness = 1.dp)
        TextLine(text = mail, imageVector = Icons.Filled.Email)
    }
}

@Preview(showBackground = false)
@Composable
fun BottomSectionPreview() {
    BusinessCardTheme {
        BottomSection(
            stringResource(id = R.string.phone),
            stringResource(id = R.string.social),
            stringResource(id = R.string.mail)
        )
    }
}

@Composable
fun TextLine(text: String, imageVector: ImageVector) {
    Row(modifier = Modifier.padding(vertical = 8.dp), horizontalArrangement = Arrangement.Start) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(text = text, color = Color.White)
    }
}