package com.example.daggerhilt

import javax.inject.Inject


interface RegisterApi{

    fun saveUser()

}



class RegistrationRepository @Inject constructor(val emailService: EmailService):RegisterApi {
    @Inject
    lateinit var registrationService: UserRegistrationService
    override fun saveUser() {
        registrationService.saveUserToMongo()
        emailService.sendEmail()
    }
}


class SaveToLocal @Inject constructor(val messageService: MessageService) :RegisterApi{

    @Inject
    lateinit var registrationService: UserRegistrationService
    override fun saveUser() {
        registrationService.saveToLocal()
        messageService.sendMessage()

    }

}


