package com.front.pam.pam_frontend.model

object CookieContainer{

    private var sessionId : String

    init {
        sessionId = ""
    }

    fun setSessionId(id : String){
        this.sessionId = id
    }

    fun getSessionId(): String {
        return this.sessionId
    }
}