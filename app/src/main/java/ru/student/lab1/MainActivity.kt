package ru.student.lab1
// Лабораторная работа №1
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private val processor = LongestWordsProcessor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputText = findViewById<EditText>(R.id.inputText)
        val processButton = findViewById<Button>(R.id.processButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        processButton.setOnClickListener {
            val text = inputText.text.toString()
            if (text.isBlank()) {
                Toast.makeText(this, "Сначала введите текст", Toast.LENGTH_SHORT).show()
                resultText.text = "Нет текста для обработки."
            } else {
                val words = processor.findFiveLongestWords(text)
                resultText.text = if (words.isEmpty()) {
                    "В тексте не найдено слов."
                } else {
                    words.mapIndexed { index, word ->
                        "${index + 1}. $word — ${word.length} симв."
                    }.joinToString(separator = "\n")
                }
            }
        }
    }
}
