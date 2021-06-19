package jp.techacademy.ayumi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_secondactivity.*



class Secondactivity:AppCompatActivity() {

    override  fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState )
         setContentView(R.layout.activity_secondactivity)
        // 答えを受け取る
        val intent = intent
        val value1 = intent.getDoubleExtra("RESULT", 0.0)
        // 答えを表示する
        resaluttext.text = value1.toString()

    }
}