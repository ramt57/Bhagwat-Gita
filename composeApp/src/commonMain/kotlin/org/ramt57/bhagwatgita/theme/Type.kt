package org.ramt57.bhagwatgita.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import bhagwatgita.composeapp.generated.resources.Mukta_Bold
import bhagwatgita.composeapp.generated.resources.Mukta_ExtraBold
import bhagwatgita.composeapp.generated.resources.Mukta_ExtraLight
import bhagwatgita.composeapp.generated.resources.Mukta_Light
import bhagwatgita.composeapp.generated.resources.Mukta_Medium
import bhagwatgita.composeapp.generated.resources.Mukta_Regular
import bhagwatgita.composeapp.generated.resources.Mukta_SemiBold
import bhagwatgita.composeapp.generated.resources.Res

@Composable
fun MuktaFontFamily() = FontFamily(
    Font(resource = Res.font.Mukta_Bold, weight = FontWeight.Bold),
    Font(resource = Res.font.Mukta_Regular, weight = FontWeight.Normal),
    Font(resource = Res.font.Mukta_Medium, weight = FontWeight.Medium),
    Font(resource = Res.font.Mukta_SemiBold, weight = FontWeight.SemiBold),
    Font(resource = Res.font.Mukta_Light, weight = FontWeight.Light),
    Font(resource = Res.font.Mukta_ExtraLight, weight = FontWeight.ExtraLight),
    Font(resource = Res.font.Mukta_ExtraBold, weight = FontWeight.ExtraBold),
)

// Default Material 3 typography values
val baseline = Typography()

@Composable
fun AppTypography() = Typography().run {
    val fontFamily = MuktaFontFamily()
    copy(
        displayLarge = baseline.displayLarge.copy(fontFamily = fontFamily),
        displayMedium = baseline.displayMedium.copy(fontFamily = fontFamily),
        displaySmall = baseline.displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = baseline.titleLarge.copy(fontFamily = fontFamily),
        titleMedium = baseline.titleMedium.copy(fontFamily = fontFamily),
        titleSmall = baseline.titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = baseline.bodySmall.copy(fontFamily = fontFamily),
        labelLarge = baseline.labelLarge.copy(fontFamily = fontFamily),
        labelMedium = baseline.labelMedium.copy(fontFamily = fontFamily),
        labelSmall = baseline.labelSmall.copy(fontFamily = fontFamily),
    )
}

