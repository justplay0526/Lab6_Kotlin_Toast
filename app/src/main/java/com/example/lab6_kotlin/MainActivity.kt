package com.example.lab6_kotlin

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6_kotlin.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDialog.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件")
            dialog.setNeutralButton("取消") { dialog, i ->
                Toast.makeText(this, "dialog關閉", Toast.LENGTH_SHORT
                ).show()
            }
            dialog.setNegativeButton("自定義Toast") { dialog, i -> showToast() }
            dialog.setPositiveButton("顯示List") { dialog, i -> showListDialog() }
            dialog.show()
        }
    }

    private fun showToast() {
        val toast = Toast(this)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layoutInflater.inflate(R.layout.custom_toast,null)
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("Message1", "Message2", "Message3", "Message4", "Message5")
        val dialog_list = AlertDialog.Builder(this)
        dialog_list.setTitle("使用List呈現")
        dialog_list.setItems(
            list
        ) { dialog, i ->
            Toast.makeText(
                this,
                "你選的是" + list[i], Toast.LENGTH_SHORT
            ).show()
        }
        dialog_list.show()
    }
}