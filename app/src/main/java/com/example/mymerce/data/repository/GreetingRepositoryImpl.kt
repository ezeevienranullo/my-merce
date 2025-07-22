package com.example.mymerce.data.repository

import com.example.mymerce.domain.GreetingRepository
import javax.inject.Inject

class GreetingRepositoryImpl @Inject constructor() : GreetingRepository {
    override fun getGreeting(): String = "Hello from the Repository!"
}

