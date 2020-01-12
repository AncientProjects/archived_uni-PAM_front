package com.front.pam.pam_frontend.model

import java.io.Serializable

data class Author(val authorId : String = "",
                val firstName : String = "",
                val lastName : String = "") : Serializable{
}

data class AuthorsList(val authors : List<Author> = emptyList()){

    fun get(index : Int) : Author? {
        return authors.elementAtOrNull(index);
    }
}