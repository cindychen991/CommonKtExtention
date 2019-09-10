package com.cindy.extention

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.cindy.lib.ktx.*
import kotlinx.android.synthetic.main.activity_sample.*

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        tvDoIf.setOnClickListener { view ->
            view.doIf({ etDoIf.text.toString() == "doIf" }, ifDo = {
                // visibility = View.VISIBLE
                Toast.makeText(this@SampleActivity, "输入为doIf", Toast.LENGTH_SHORT).show()
            }, ifNot = {
                // visibility = View.GONE
                Toast.makeText(this@SampleActivity, "输入不匹配", Toast.LENGTH_SHORT).show()
            })
        }

        tvDoIfNot.setOnClickListener { view ->
            view.doIfNot({ etDoIf.text.toString() == "doIfNot" }) {
                Toast.makeText(this@SampleActivity, "输入不匹配", Toast.LENGTH_SHORT).show()
            }
        }

        tvDoIfNull.setOnClickListener {
            etDoIf.text.toString().doIfEmptyOrNot(ifDo = {
                Toast.makeText(this@SampleActivity, "当前输入内容为空", Toast.LENGTH_SHORT).show()
            }, ifNot = { content ->
                Toast.makeText(this@SampleActivity, "当前输入内容为：$content", Toast.LENGTH_SHORT).show()
            })
        }

        "".doIfEmpty{

        }
    }

}
