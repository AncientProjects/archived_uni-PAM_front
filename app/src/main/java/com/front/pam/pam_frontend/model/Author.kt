package com.front.pam.pam_frontend.model

data class Author(val authorId : String = "",
                val firstName : String = "",
                val lastName : String = "") {
}

data class AuthorsList(val authors : List<Author> = emptyList()){

    fun get(index : Int) : Author? {
        return authors.elementAtOrNull(index);
    }
}