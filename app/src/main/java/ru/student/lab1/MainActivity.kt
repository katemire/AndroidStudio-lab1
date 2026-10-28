package ru.student.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val sourceText =
        "Программирование позволяет создавать удивительные приложения. " +
        "Алгоритмы обрабатывают информацию, последовательность определяет результат. " +
        "Самостоятельность и внимательность помогают совершенствовать программирование."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sourceTextView = findViewById<TextView>(R.id.sourceText)
        val resultTextView = findViewById<TextView>(R.id.resultText)
        val processButton = findViewById<Button>(R.id.processButton)

        sourceTextView.text = sourceText

        val processor = LongestWordsProcessor()

        processButton.setOnClickListener {
            val words = processor.findFiveLongestWords(sourceText)

            resultTextView.text = if (words.isEmpty()) {
                "В тексте не найдено ни одного слова."
            } else {
                words.mapIndexed { index, word ->
                    "${index + 1}. $word — ${word.length} симв."
                }.joinToString(separator = "\n")
            }
        }
    }
}