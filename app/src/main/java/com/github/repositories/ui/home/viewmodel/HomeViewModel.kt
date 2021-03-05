package com.github.repositories.ui.home.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.repositories.data.Resource
import com.github.repositories.data.model.User
import com.github.repositories.data.respository.UserRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val usersLiveDataPrivate = MutableLiveData<Resource<List<User>>>()
    val usersLiveData: LiveData<Resource<List<User>>> get() = usersLiveDataPrivate

    fun searchUsers(query:String) {
        viewModelScope.launch {
            usersLiveDataPrivate.value = Resource.Loading()
            userRepository.searchUser(query).collect {
                usersLiveDataPrivate.value = it
            }
        }
    }
}