package ui

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.TextArea

@Composable
fun jsonInputView(json: String, onInput: (String) -> Unit) {
    Div {
        TextArea {
            value(json)
            this@TextArea.onInput {
                onInput(it.value)
            }
            style {
                width(100.percent)
                height(500.px)
                marginTop(5.px)
                marginBottom(5.px)
            }
        }
    }
}