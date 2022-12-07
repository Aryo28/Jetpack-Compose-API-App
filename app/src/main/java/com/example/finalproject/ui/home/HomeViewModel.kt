package com.example.finalproject.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.userApi.user.data.api.model.User
import com.example.finalproject.userApi.user.data.repository.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private var userRep: UserRepo
):ViewModel(){
    private val _state = MutableStateFlow(emptyList<User>())
    val state:StateFlow<List<User>>
    get() = _state

    init{
        viewModelScope.launch {
            val users = userRep.getUsers()
            _state.value = users
        }
    }




}