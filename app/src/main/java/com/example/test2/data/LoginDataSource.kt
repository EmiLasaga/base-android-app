package com.example.test2.data

import clients.RestClient
import com.example.test2.data.model.LoggedInUser
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import java.io.IOException


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    private val client = OkHttpClient()

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            makePost(username,password)
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Emilia Lasaga")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }

    private fun makePost(email: String, password: String) {

        val params = RequestParams(mutableMapOf("email" to email, "password" to password,
        "name" to "Emilia", "lastname" to "Lasaga"))

        RestClient.post("registration", params, JsonHttpResponseHandler())
    }
}