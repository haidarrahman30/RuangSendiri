package com.example.aplikasihitungvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class KubusActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var sisi: EditText
    private lateinit var btn_hitung: Button
    private lateinit var hasil: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kubus)

        sisi = findViewById(R.id.sisi)
        btn_hitung = findViewById(R.id.btn_hitung)
        hasil = findViewById(R.id.hasil)

        btn_hitung.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(KubusActivity.STATE_RESULT)
            hasil.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KubusActivity.STATE_RESULT, hasil.text.toString())
    }


    override fun onClick(v: View) {
        if (v.id == R.id.btn_hitung) {
            val inputSisi = sisi.text.toString().trim()

            var isEmptyFields = false

            /*
            Validasi apakah inputan masih ada yang kosong
             */
            when {
                inputSisi.isEmpty() -> {
                    isEmptyFields = true
                    sisi.error = "Field ini tidak boleh kosong"
                }
            }
            /*
            Jika semua inputan valid maka tampilkan hasilnya
             */
            if (!isEmptyFields) {
                val volume = inputSisi.toDouble() * inputSisi.toDouble()
                hasil.text = "Volume Adalah : " + volume.toString()
            }
        }
    }
}