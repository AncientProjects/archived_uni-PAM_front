package com.front.pam.pam_frontend.model

import java.security.MessageDigest

class Utils {

    val md5 : MessageDigest

    init {
        md5 = MessageDigest.getInstance("MD5")
    }

    fun toMD5Hash( text: String ): String {
        var input = text
        if (input == null)
            input = ""
        val md5HashBytes = md5.digest(input.toByteArray()).toTypedArray()
        return byteArrayToHexString(md5HashBytes)
    }

    private fun byteArrayToHexString( array: Array<Byte> ): String {

        var result = StringBuilder(array.size * 2)

        for ( byte in array ) {

            val toAppend =
                String.format("%2x", byte).replace(" ", "0") // hexadecimal
            result.append(toAppend)
        }
        //result.setLength(result.length - 1) // remove last '-'

        return result.toString()
    }

}