package com.hamcoding.hellocompose

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hamcoding.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeTheme {
                surfaceExample()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ComposePreview() {
        HelloComposeTheme {
            surfaceExample()
        }
    }

    /** 01. 텍스트 */
    @Composable
    fun Greeting(name: String) {
        Text(
            modifier = Modifier.width(300.dp),
            text = "Hello $name\nHello $name\nHello $name",
            color = Color.Blue,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 2.sp,
            maxLines = 2,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Start,
        )
    }

    /** 02. 버튼 */
    @Composable
    fun ButtonExample(onButtonClicked: () -> Unit) {
        Button(
            onClick = onButtonClicked,
            enabled = true,
            border = BorderStroke(3.dp, Color.Magenta),
            shape = CircleShape,
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }
    }

    /** 03. Modifier */
    @Composable
    fun ModifierExample() {
        Button(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Cyan,
            ),
            onClick = {},
            modifier = Modifier
                .size(width = 200.dp, height = 300.dp)
                .padding(10.dp),
            shape = RoundedCornerShape(20.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                modifier = Modifier.background(Color.Blue)
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                "Search",
                modifier = Modifier.offset(y = 10.dp)
            )
        }
    }

    /** 04. Surface */
    @Composable
    fun surfaceExample() {
        Surface(
            modifier = Modifier.padding(5.dp),
            shadowElevation = 10.dp,
            shape = CircleShape,
            color = MaterialTheme.colorScheme.onError
        ) {
            Text(
                text = "Hello Android!",
                fontSize = 15.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}