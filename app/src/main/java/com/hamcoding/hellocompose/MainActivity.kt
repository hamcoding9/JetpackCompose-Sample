package com.hamcoding.hellocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hamcoding.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeTheme {
                CatalogEx(itemList = items)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ComposePreview() {
        HelloComposeTheme {
            CatalogEx(itemList = items)
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
    fun SurfaceExample() {
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

    /** 05. Box */
    @Composable
    fun BoxExample() {
        Box(
            modifier = Modifier.size(100.dp)
        ) {
            Text(text = "Hello", modifier = Modifier.align(Alignment.BottomEnd))
            Text(
                text = "Jetpack",
                color = Color.Blue,
                modifier = Modifier.align(Alignment.TopEnd)
            )
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(Color.Cyan)
                    .align(Alignment.CenterStart)
            ) {
                Text(text = "y", modifier = Modifier.align(Alignment.Center))
            }
        }
    }

    /** 06. Row */
    @Composable
    fun RowExample() {
        Row(
            modifier = Modifier
                .height(40.dp)
                .width(200.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = "첫 번째!",
                modifier = Modifier.align(Alignment.Top),
                textAlign = TextAlign.Center
            )
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "추가",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(text = "세 번째!", modifier = Modifier.align(Alignment.Bottom))
        }
    }

    /** 07. Column */
    @Composable
    fun ColumnExample() {
        Column(
            modifier = Modifier.size(100.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "첫 번째!"
            )
            Text(
                text = "두 번째!"
            )
            Text(
                text = "세 번째!"
            )
        }
    }

    /** 08. BoxWithConstraints */
    @Composable
    fun Outer() {
        Column {
            Inner(
                modifier = Modifier
                    .widthIn(min = 100.dp, max = 350.dp)
                    .height(150.dp)
            )
        }
    }

    @Composable
    private fun Inner(modifier: Modifier = Modifier) {
        BoxWithConstraints(modifier) {
            if (maxWidth > 200.dp) {
                Text(
                    text = "여기 꽤 길군요!",
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
            Text("minW: $minWidth maxW: $maxWidth")
        }
    }

    /** 09. Image */
    @Composable
    private fun ImageExample() {
        Column {
            Image(
                painter = painterResource(id = R.drawable.wall),
                contentDescription = "엔텔로프 캐년"
            )
            Image(
                imageVector = Icons.Filled.Settings,
                contentDescription = "세팅"
            )
        }
    }

    /** 10. Network Image */
    @Composable
    private fun NetworkImageExample() {
        val uri =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/USA_Antelope-Canyon.jpg/1200px-USA_Antelope-Canyon.jpg"
        Column {
            AsyncImage(
                model = uri,
                contentDescription = "자연"
            )
            AsyncImage(
                model = uri,
                contentDescription = "자연"
            )
        }
    }

    private val cardData = CardData(
        imageUri = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/USA_Antelope-Canyon.jpg/1200px-USA_Antelope-Canyon.jpg",
        imageDescription = "엔텔로프 캐년",
        author = "Park",
        description = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개되었습니다."
    )

    /** 11. Card */
    @Composable
    private fun CardExample(card: CardData) {
        val placeHolderColor = Color(0x33000000)

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                AsyncImage(
                    model = card.imageUri,
                    contentScale = ContentScale.Crop,
                    contentDescription = card.imageDescription,
                    placeholder = ColorPainter(placeHolderColor),
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    Text(text = card.author)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = card.description)
                }
            }
        }
    }

    /** 12. Check Box */
    @Composable
    private fun CheckboxExample() {
        // delegated properties
        var checked by remember { mutableStateOf(false) }
        // destruction
        val (getter, setter) = remember { mutableStateOf(false) }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = !checked
                }
            )
            Checkbox(
                checked = getter,
                onCheckedChange = setter
            )
            Text(
                text = "프로그래머입니까?",
                modifier = Modifier.clickable {
                    setter(!getter)
                }
            )
        }
    }

    /** 13. Text Field */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TextFieldExample() {
        var name by remember { mutableStateOf("Tom") }
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TextField(
                value = name,
                label = {
                    Text("이름")
                },
                onValueChange = { name = it })
            Spacer(modifier = Modifier.size(8.dp))
            OutlinedTextField(
                value = name,
                label = {
                    Text("이름")
                },
                onValueChange = { name = it })
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Hello $name")
        }
    }

    /** 14. Top AppBar */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TopBarEx() {
        TopAppBar(
            title = { Text("TopAppBar") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "업 네비게이션"
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
            }
        )
    }

    @Composable
    fun CheckBoxWithSlot(
        checked: Boolean,
        onCheckedChanged: () -> Unit,
        content: @Composable RowScope.() -> Unit
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                onCheckedChanged()
            }
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    onCheckedChanged()
                }
            )
            content()
        }
    }

    @Composable
    fun SlotEx() {
        var checked1 by remember { mutableStateOf(false) }
        var checked2 by remember { mutableStateOf(false) }

        Column {
            CheckBoxWithSlot(checked = checked1, onCheckedChanged = {
                checked1 = !checked1
            }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "추가"
                )
                Text(text = "예시")
            }
            CheckBoxWithSlot(checked = checked2, onCheckedChanged = {
                checked2 = !checked2
            }) {
                Text(text = "뿡")
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScaffoldEx() {
        Scaffold(topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로 가기"
                        )
                    }
                },
                title = {
                    Text(text = "Scaffold App")
                }
            )
        }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Text("반가워요")
            }
        }
    }

    @Composable
    fun Item(itemData: ItemData) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(itemData.imageId),
                    contentDescription = itemData.title
                )
                Text(
                    text = itemData.title,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(
                    modifier = Modifier.size(8.dp)
                )
                Text(
                    text = itemData.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

    data class ItemData(
        @DrawableRes val imageId: Int,
        val title: String,
        val description: String
    )

    @Composable
    fun CatalogEx(itemList: List<ItemData>) {
        LazyColumn {
            items(itemList) { item ->
                Item(item)
            }
        }
    }

    val items = listOf(
        ItemData(
            imageId = R.drawable.a1,
            title = "해변 놀이 공원",
            description = "해변 놀이 공원 설명입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
        ),
        ItemData(
            imageId = R.drawable.a2,
            title = "캐년",
            description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
        ),
        ItemData(
            imageId = R.drawable.a3,
            title = "워터월드",
            description = "워터월드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
        ),
        ItemData(
            imageId = R.drawable.a5,
            title = "라스베가스",
            description = "라스베가스입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
        ),
        ItemData(
            imageId = R.drawable.a6,
            title = "호르슈 밴드",
            description = "호르슈 밴드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
        ),
        ItemData(
            imageId = R.drawable.a7,
            title = "미국의 길",
            description = "미국의 길입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
        ),
        ItemData(
            imageId = R.drawable.a8,
            title = "엔텔로프 캐년",
            description = "엔텔로프 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
        ),
        ItemData(
            imageId = R.drawable.a9,
            title = "그랜드 캐년",
            description = "그랜드 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
        ),
    )
}