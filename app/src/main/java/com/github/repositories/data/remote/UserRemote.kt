package com.github.repositories.data.remote

import com.github.repositories.data.Resource
import com.github.repositories.data.apiservice.UserService
import com.github.repositories.data.error.NETWORK_ERROR
import com.github.repositories.data.model.User
import javax.inject.Inject
import com.github.repositories.data.model.Result
import retrofit2.Response
import java.io.IOException

class UserRemote @Inject
constructor (private val userService: UserService) {

    suspend fun searchUser(name:String): Resource<List<User>> {
        val response = processCall(userService.search(name))
        return when (response) {
            is Result -> {
                Resource.Success(data = response.items as ArrayList<User>)
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private fun processCall(response: Response<*>): Any?{
        return try{
            if(response.isSuccessful){
                response.body() as Result
            }
            else{
                response.code()
            }
        }catch (e: IOException){
            NETWORK_ERROR
        }
    }
}