package com.example.aplikasihitungvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class TabungActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var jari: EditText
    private lateinit var tinggi: EditText
    private lateinit var btn_hitung: Button
    private lateinit var hasil: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabung)

        jari = findViewById(R.id.sisi)
        tinggi = findViewById(R.id.tinggi)
        btn_hitung = findViewById(R.id.btn_hitung)
        hasil = findViewById(R.id.hasil)

        btn_hitung.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(TabungActivity.STATE_RESULT)
            hasil.text = result
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TabungActivity.STATE_RESULT, hasil.text.toString())
    }


    override fun onClick(v: View) {
        if (v.id == R.id.btn_hitung) {
            val inputjari = jari.text.toString().trim()
            val inputTinggi = tinggi.text.toString().trim()

            var isEmptyFields = false

            /*
            Validasi apakah inputan masih ada yang kosong
             */
            when {
                inputjari.isEmpty() -> {
                    isEmptyFields = true
                    jari.error = "Field ini tidak boleh kosong"
                }
                inputTinggi.isEmpty() -> {
                    isEmptyFields = true
                    tinggi.error = "Field ini tidak boleh kosong"
                }
            }

            /*
            Jika semua inputan valid maka tampilkan hasilnya
             */
            if (!isEmptyFields) {
                val volume = 3.14 * inputjari.toFloat() * inputjari.toFloat() *  inputTinggi.toFloat()
                hasil.text = "Volume Adalah : " + volume.toString()
            }
        }
    }
    
    
}