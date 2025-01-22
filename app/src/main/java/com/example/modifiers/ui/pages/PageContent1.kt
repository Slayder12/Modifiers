package com.example.modifiers.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PageContent1(
    pageName: String,
    modifier: Modifier = Modifier,
    greetingText: String = "Привет",
    textColor: Color = Color.Black,
    fontSize: TextUnit = 24.sp,
    innerSurfaceColor: Color = Color.Yellow,
    borderColor: Color = Color.Red,
    borderWidth: Dp = 2.dp,
    cornerShape: Shape = RoundedCornerShape(2.dp),
    paddingValues: PaddingValues = PaddingValues(16.dp),
    textPaddingValues: PaddingValues = PaddingValues(3.dp)
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        when {
            modifier == Modifier -> {
                Text(
                    text = greetingText,
                    fontSize = fontSize,
                    color = textColor,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(paddingValues)
                )
            }

            modifier == Modifier.fillMaxSize() -> {
                Surface(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 100.dp),
                    shape = cornerShape,
                    color = Color.Transparent,
                    border = BorderStroke(borderWidth, borderColor)
                ) {
                    Text(
                        text = greetingText,
                        fontSize = fontSize,
                        color = textColor,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }

            else -> {
                Surface(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 100.dp),
                    shape = cornerShape,
                    color = Color.Transparent,
                    border = BorderStroke(borderWidth, borderColor)
                ) {
                    Surface(
                        modifier = Modifier.padding(paddingValues),
                        shape = cornerShape,
                        color = innerSurfaceColor,
                        border = BorderStroke(borderWidth, borderColor)
                    ) {
                        Text(
                            text = greetingText,
                            fontSize = fontSize,
                            color = textColor,
                            modifier = Modifier.padding(textPaddingValues)
                                .padding(horizontal = 10.dp)

                        )
                    }
                }
            }
        }

    }
}