package com.example.modifiers.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modifiers.ui.theme.Teal200

@Composable
fun PageContent2(
    pageName: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        if (modifier == Modifier) {

            Text(
                text = "Привет",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.padding(5.dp)
            )
        } else {
            Surface(
                modifier = Modifier.size(400.dp)
                    .padding(5.dp),
                shape = CircleShape,
                color = Teal200,
                border = BorderStroke(1.dp, Color.Green)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Привет",
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }


}