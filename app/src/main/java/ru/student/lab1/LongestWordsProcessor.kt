package ru.student.lab1

class LongestWordsProcessor {

    fun findFiveLongestWords(text: String): List<String> {
        return text
            .lowercase()
            .split(Regex("[^\\p{L}]+"))
            .filter { it.isNotBlank() }
            .distinct()
            .sortedWith(
                compareByDescending<String> { it.length }
                    .thenBy { it }
            )
            .take(5)
    }
}