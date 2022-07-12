import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.browser.window
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

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
            Div {
                TextArea {
                    value(inputJson)
                    this@TextArea.onInput {
                        inputJson = it.value
                    }
                    style {
                        width(100.percent)
                        height(500.px)
                        marginTop(5.px)
                        marginBottom(5.px)
                    }
                }

            }
            Div {
                Button(
                    attrs = {
                        onClick {
                            GlobalScope.launch(Dispatchers.Main) {
                                println("start generate Code")
                                val code = generateKotlinCode(inputJson)
                                window.navigator.clipboard.writeText(code).await()
                                window.alert("already paste to your paster")
                            }
                        }
                    }
                ) {
                    Text("Generate And Copy to Paste")
                }
            }
        }
    }
}

val httpClient = HttpClient {
    install(ContentNegotiation) {
        json()
    }
}

suspend fun generateKotlinCode(json: String): String {
    val response = httpClient.post(url = Url("https://jsontokotlin.sealwu.com/generate")) {
        contentType(ContentType.Application.Json)
        setBody(GenerateRequest(json = json, className = "Yes"))
    }
    return response.bodyAsText()
}