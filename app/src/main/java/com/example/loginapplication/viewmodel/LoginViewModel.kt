package com.example.loginapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val loginSuccess = MutableLiveData<Boolean>()

    fun loginUser(username: String, password: String) {
        val isValid = validateCredentials(username, password)
        loginSuccess.value = isValid
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        // Implement validation logic
        // For simplicity, checking against hardcoded values
        return username == "Fininfocom" && password == "Fin@123"
    }
}
