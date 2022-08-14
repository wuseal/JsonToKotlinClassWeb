import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import model.Repository
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import ui.jsonInputView

fun main() {


    var inputJson: String by mutableStateOf("")

    renderComposable(rootElementId = "root") {

        Div({
            style {
                width(50.percent)
                property("margin", "0 auto")
            }
        }) {

            Text("Input JSON Next")
            jsonInputView(inputJson) {
                inputJson = it
            }

            val scope = rememberCoroutineScope()
            Div {
                Button(
                    attrs = {
                        onClick {
                            scope.launch {
                                println("start generate Code")
                                val code = Repository.generateKotlinCode(inputJson)
                                window.navigator.clipboard.writeText(code).await()
                                window.alert("Already copied to your clipboard")
                            }
                        }
                    }
                ) {
                    Text("Generate Kotlin Class And Copy To Clipboard")
                }
            }
        }
    }
}