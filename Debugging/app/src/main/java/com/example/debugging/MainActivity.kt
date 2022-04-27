package com.example.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity" //the class referred by the log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "This is where the app crashed before")
        setContentView(R.layout.activity_main)
        var hello: TextView = findViewById(R.id.hello_world)
        Log.d(TAG, "this should be displayed if the bug is fixed")
        hello.text = "Hello, debugging!"
        logging()
        division()
    }

    fun division() {
        val numerator = 60
        var denominator = 4
        repeat(4) {
            Thread.sleep(3)
            findViewById<TextView>(R.id.division_view).setText("${numerator / denominator}")
            Log.v(TAG, "${numerator / denominator}")
            denominator--
        }
    }
    fun logging() {
        Log.e(TAG, "ERROR: A serious error like an app crash")
        Log.w(TAG, "WARN: Warns about a potential for serious errors")
        Log.i(TAG, "INFO: Reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: Reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: More verbose than DEBUG logs")
    }
}