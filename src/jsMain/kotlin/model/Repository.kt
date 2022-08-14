package model

import http.httpClient
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

object Repository {
    suspend fun generateKotlinCode(json: String): String {
        val response = httpClient.post(url = Url("https://jsontokotlin.sealwu.com/generate")) {
            contentType(ContentType.Application.Json)
            setBody(GenerateRequest(json = json, className = "JsonModel"))
        }
        return response.bodyAsText()
    }
}