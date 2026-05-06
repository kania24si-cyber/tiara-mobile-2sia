package com.example.tiara_distinctive.Home.pertemuan_3_laporan

import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tiara_distinctive.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar

class RegistrasiActivity : AppCompatActivity() {

    private lateinit var etNama: TextInputEditText
    private lateinit var etTanggal: TextInputEditText
    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirm: TextInputEditText

    private lateinit var layoutNama: TextInputLayout
    private lateinit var layoutTanggal: TextInputLayout
    private lateinit var layoutUsername: TextInputLayout
    private lateinit var layoutPassword: TextInputLayout
    private lateinit var layoutConfirm: TextInputLayout

    private lateinit var radioGroupJK: RadioGroup
    private lateinit var spinnerAgama: Spinner

    private lateinit var tvErrorJK: TextView
    private lateinit var tvErrorAgama: TextView

    private lateinit var btnRegister: Button

    private lateinit var sharedPref: SharedPreferences

    private val agama = arrayOf(
        "Pilih Agama",
        "Islam",
        "Kristen",
        "Katolik",
        "Hindu",
        "Budha",
        "Konghucu"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrasi)

        init()

        sharedPref = getSharedPreferences("session_user", MODE_PRIVATE)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            agama
        )

        spinnerAgama.adapter = adapter

        etTanggal.setOnClickListener {
            showDatePicker()
        }

        btnRegister.setOnClickListener {
            validasiForm()
        }
    }

    private fun init() {

        etNama = findViewById(R.id.etNama)
        etTanggal = findViewById(R.id.etTanggal)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirm = findViewById(R.id.etConfirm)

        layoutNama = findViewById(R.id.layoutNama)
        layoutTanggal = findViewById(R.id.layoutTanggal)
        layoutUsername = findViewById(R.id.layoutUsername)
        layoutPassword = findViewById(R.id.layoutPassword)
        layoutConfirm = findViewById(R.id.layoutConfirm)

        radioGroupJK = findViewById(R.id.radioGroupJK)
        spinnerAgama = findViewById(R.id.spinnerAgama)

        tvErrorJK = findViewById(R.id.tvErrorJK)
        tvErrorAgama = findViewById(R.id.tvErrorAgama)

        btnRegister = findViewById(R.id.btnRegister)
    }

    private fun showDatePicker() {

        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, y, m, d ->

                etTanggal.setText("$d/${m + 1}/$y")

            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private fun validasiForm() {

        // reset error
        layoutNama.error = null
        layoutTanggal.error = null
        layoutUsername.error = null
        layoutPassword.error = null
        layoutConfirm.error = null

        tvErrorJK.text = ""
        tvErrorAgama.text = ""

        val nama = etNama.text.toString().trim()
        val tanggal = etTanggal.text.toString().trim()
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val confirm = etConfirm.text.toString().trim()

        var valid = true

        // VALIDASI NAMA
        if (nama.isEmpty()) {
            layoutNama.error = "Nama wajib diisi"
            valid = false
        }

        // VALIDASI TANGGAL
        if (tanggal.isEmpty()) {
            layoutTanggal.error = "Tanggal lahir wajib diisi"
            valid = false
        }

        // VALIDASI JK
        if (radioGroupJK.checkedRadioButtonId == -1) {
            tvErrorJK.text = "Pilih jenis kelamin"
            valid = false
        }

        // VALIDASI AGAMA
        if (spinnerAgama.selectedItemPosition == 0) {
            tvErrorAgama.text = "Pilih agama"
            valid = false
        }

        // VALIDASI USERNAME
        if (username.isEmpty()) {
            layoutUsername.error = "Username wajib diisi"
            valid = false
        }

        // VALIDASI PASSWORD
        if (password.isEmpty()) {
            layoutPassword.error = "Password wajib diisi"
            valid = false
        }

        // VALIDASI CONFIRM PASSWORD
        if (confirm.isEmpty()) {
            layoutConfirm.error = "Confirm Password wajib diisi"
            valid = false
        }

        // PASSWORD HARUS SAMA
        if (password != confirm) {
            layoutConfirm.error = "Password tidak sama"
            valid = false
        }

        // JIKA VALID
        if (valid) {

            val editor = sharedPref.edit()

            editor.putString("nama", nama)
            editor.putString("tanggal", tanggal)
            editor.putString("username", username)
            editor.putString("password", password)

            // simpan jenis kelamin
            if (radioGroupJK.checkedRadioButtonId == R.id.rbLaki) {
                editor.putString("jk", "Laki-Laki")
            } else {
                editor.putString("jk", "Perempuan")
            }

            // simpan agama
            editor.putString(
                "agama",
                spinnerAgama.selectedItem.toString()
            )

            editor.apply()

            MaterialAlertDialogBuilder(this)
                .setTitle("Registrasi Berhasil")
                .setMessage("Data berhasil disimpan")
                .setPositiveButton("OK") { _, _ ->

                    startActivity(
                        Intent(this, LoginActivity::class.java)
                    )

                    finish()
                }
                .show()
        }
    }
}