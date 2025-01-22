package com.example.modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.modifiers.ui.pages.PageContent1
import com.example.modifiers.ui.pages.PageContent2
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pages()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Pages() {
    val pagerState = rememberPagerState()

    val pages = listOf<@Composable () -> Unit>(
        { PageContent1("Page 1") },
        { PageContent1("Page 2", Modifier.fillMaxSize()) },
        {
            PageContent1(
                "Page 3",
                Modifier.padding(2.dp),
                greetingText = "Привет",
                textColor = Color.Black,
                borderColor = Color.Red,
                borderWidth = 2.dp,
                cornerShape = RoundedCornerShape(1.dp),
                paddingValues = PaddingValues(20.dp)
            )
        },
        { PageContent2("Page 4") },
        { PageContent2("Page 5", Modifier.fillMaxSize()) }
    )

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            pages[page]()
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}