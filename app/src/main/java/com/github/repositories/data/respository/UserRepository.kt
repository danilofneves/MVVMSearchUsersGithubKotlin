package com.github.repositories.data.respository

import com.github.repositories.data.Resource
import com.github.repositories.data.model.User
import com.github.repositories.data.remote.UserRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UserRepository @Inject constructor(private val userRemote: UserRemote) {

    var backgroundContext: CoroutineContext = Dispatchers.IO

    suspend fun searchUser(name:String): Flow<Resource<List<User>>> {
        return flow {
            emit(userRemote.searchUser(name))
        }.flowOn(backgroundContext)
    }
}