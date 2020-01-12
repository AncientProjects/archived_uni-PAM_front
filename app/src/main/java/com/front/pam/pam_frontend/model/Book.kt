package com.front.pam.pam_frontend.model

data class Book(val bookId : String = "",
                val authorId : String = "",
                val author : Author? = null,
                val title : String = "",
                val categoryId : String = "",
                val year : Int = -1,
                val ratingAvg : Double = -1.0) {
}

data class BooksList(val booksTO : List<Book> = emptyList()){

    fun get(index : Int) : Book? {
        return booksTO.elementAtOrNull(index)
    }
}
