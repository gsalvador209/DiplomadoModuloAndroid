package com.cvgs.androidmodule1.finalexercise

import java.io.Serializable

data class UserEntity(
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
    val gender: String
) : Serializable