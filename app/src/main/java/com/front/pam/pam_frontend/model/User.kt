package com.front.pam.pam_frontend.model

data class User(var nickname : String = "",
                var firstName : String = "",
                var lastName : String = "",
                var pwdHash : String = ""){

    fun validate(): Boolean {
        if (nickname == null || nickname.isEmpty())
            return false;
        if (firstName == null || firstName.isEmpty())
            return false;
        if (lastName == null || lastName.isEmpty())
            return false;
        if (pwdHash == null || pwdHash.isEmpty())
            return false;

        return true;
    }
}