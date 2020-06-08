package clients

import android.content.Context
import android.content.Entity
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.HttpEntity
import cz.msebera.android.httpclient.entity.ContentType


object RestClient {
    private const val BASE_URL = "http://10.0.2.2:8080/api/users/"
    private val client = AsyncHttpClient()
    operator fun get(
        url: String,
        params: RequestParams?,
        responseHandler: AsyncHttpResponseHandler?
    ) {
        client[getAbsoluteUrl(url), params, responseHandler]
    }

    fun post(
        url: String,
        params: RequestParams?,
        responseHandler: AsyncHttpResponseHandler?
    ) {
        client.post(
            getAbsoluteUrl(url),
            params,
            responseHandler
        )
    }

    fun post2(
        context: Context,
        url: String,
        entity: HttpEntity,
        contentType: String,
        responseHandler: AsyncHttpResponseHandler?
    ) {
        client.post(
            context,
            url,
            entity,
            contentType,
            responseHandler
        )
    }

    private fun getAbsoluteUrl(relativeUrl: String): String {
        return BASE_URL + relativeUrl
    }
}