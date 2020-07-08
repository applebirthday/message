package xyz.daozhe.message

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_message)
    }

    fun onSendMessage(view: View?) {
        val editText = findViewById<EditText>(R.id.input)
        val message = editText.text.toString()
        val intent = Intent(this, ReceiveMessageActivity::class.java)
        intent.putExtra(MESSAGE_KEY, message)
        startActivity(intent)
    }

    fun onSendMessageToOther(view: View?) {
        val editText = findViewById<EditText>(R.id.input)
        val messageText = editText.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, messageText)
        val chosenIntent = Intent.createChooser(intent, getString(R.string.chooser))
        startActivity(chosenIntent)
    }

    companion object {
        const val MESSAGE_KEY = "xyz.daozhe.messager"
    }
}