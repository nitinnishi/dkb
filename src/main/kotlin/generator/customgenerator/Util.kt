package org.dkbfactory.generator.customgenerator

import org.dkbfactory.Util.Constants
import java.util.*

class Util {
    companion object getRandomShortString {
        fun getRandomShortString(): String {
            val random: Random = Random()
            val result = CharArray(Constants.NUM_CHARS_IN_SHORT_URL)
            for (i in 0 until Constants.NUM_CHARS_IN_SHORT_URL) {
                val randomIndex = random.nextInt(CustomGeneratorConstants.ALLOWED_CHARACTERS_IN_SHORT_URL.length - 1)
                result[i] = CustomGeneratorConstants.ALLOWED_CHARACTERS_IN_SHORT_URL[randomIndex]
            }
            println(result)
            return String(result)
        }
    }
}