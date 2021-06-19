package jp.techacademy.ayumi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.provider.ContactsContract
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener
{
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        buttonadd.setOnClickListener(this)
        Buttonsub.setOnClickListener(this)
        Buttonmul.setOnClickListener(this)
        buttondiv.setOnClickListener(this)


    }
    override fun onClick(v: View?) {
        // EditText1から値を取得してチェックする
        var value1 =
            if(addtext1.text.isNotEmpty()) {
                addtext1.text.toString().toDouble()
            } else {
                Snackbar.make(v!!, "2つ目の値が未入力です。", Snackbar.LENGTH_SHORT).show()

                    return
            }
        // EditText2から値を取得してチェックする
        var value2 =
            if(addtext2.text.isNotEmpty()) {
                addtext2.text.toString().toDouble()
            } else {
                Snackbar.make(v!!, "2つ目の値が未入力です。", Snackbar.LENGTH_SHORT).show()
                return
            }
        // 答えを計算する
        var result =
            when (v!!.id) {
                R.id.buttonadd -> value1 + value2
                R.id.Buttonsub -> value1 - value2
                R.id.Buttonmul -> value1 * value2
                R.id.buttondiv -> {
                    if (value2 == 0.0) {
                        Snackbar.make(v, "0で割ることはできません。", Snackbar.LENGTH_SHORT).show()
                        return
                    }
                    value1 / value2
                }
                else -> 0.0
            }
        // 答えを送る
        val intent = Intent(this, Secondactivity::class.java)
        intent.putExtra("RESULT", result)
        startActivity(intent)
    }
}