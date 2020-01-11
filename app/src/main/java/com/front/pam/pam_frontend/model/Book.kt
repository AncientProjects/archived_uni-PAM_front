package com.front.pam.pam_frontend.model

data class Book(val bookId : String = "",
                val authorId : String = "",
                val author : Author? = null,
                val title : String = "",
                val categoryId : String = "",
                val year : Int = -1,
                val ratingAvg : Double = -1.0) {

}