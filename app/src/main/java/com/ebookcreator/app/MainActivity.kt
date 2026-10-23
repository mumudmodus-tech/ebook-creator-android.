
package com.ebookcreator.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 24, 24, 24)
            setBackgroundColor(Color.rgb(245, 248, 255))
        }

        val scroll = ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val heading = TextView(this).apply {
            text = "EbooK Creator"
            textSize = 28f
            setTextColor(Color.rgb(30, 70, 150))
            gravity = Gravity.CENTER
        }
        content.addView(heading)

        val subtitle = TextView(this).apply {
            text = "Buat buku langsung dari HP kamu"
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(0, 8, 0, 24)
        }
        content.addView(subtitle)

        val titleInput = EditText(this).apply {
            hint = "Judul buku"
            singleLine = true
        }
        content.addView(titleInput)

        val bodyInput = EditText(this).apply {
            hint = "Mulai tulis isi buku di sini..."
            gravity = Gravity.TOP
            minLines = 8
        }
        content.addView(bodyInput)

        val saveButton = Button(this).apply {
            text = "Periksa tulisan"
            setOnClickListener {
                val title = titleInput.text.toString().trim()
                val body = bodyInput.text.toString().trim()

                if (title.isEmpty() || body.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        "Isi judul dan isi buku terlebih dahulu",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Tulisan siap: $title",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        content.addView(saveButton)

        val note = TextView(this).apply {
            text = "Versi awal: editor dasar. Fitur simpan, ekspor PDF/TXT, dan AI lokal akan ditambahkan bertahap."
            textSize = 13f
            setPadding(0, 16, 0, 0)
        }
        content.addView(note)

        scroll.addView(content)
        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(root)
    }
}
