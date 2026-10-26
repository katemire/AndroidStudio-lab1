package ru.student.lab1

class LongestWordsProcessor {
    fun findFiveLongestWords(text: String): List<String> {
        return text
            .lowercase()
            .split(Regex("[^\\p{L}\\p{N}]+"))
            .filter { word -> word.isNotBlank() }
            .distinct()
            .sortedWith(compareByDescending<String> { it.length }.thenBy { it })
            .take(5)
    }
}
