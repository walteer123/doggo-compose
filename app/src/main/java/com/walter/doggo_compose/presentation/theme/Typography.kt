package com.walter.doggo_compose.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.walter.doggo_compose.R

private val NanumGothic = FontFamily(
    Font(R.font.nanum_gothic_regular, FontWeight.W400),
    Font(R.font.nanum_gothic_bold, FontWeight.W700),
    Font(R.font.nanum_gothic_extra_bold, FontWeight.W800)
)

val DoggoTypography = Typography(
    h4 = TextStyle(
        fontFamily = NanumGothic,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = NanumGothic,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = NanumGothic,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = NanumGothic,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = NanumGothic,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = NanumGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = NanumGothic,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = NanumGothic,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = NanumGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = NanumGothic,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)