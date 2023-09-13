package com.zfadhil.doandzikrapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.zfadhil.doandzikrapp.R
import com.zfadhil.doandzikrapp.databinding.ActivityPagiPetangBinding
import com.zfadhil.doandzikrapp.presentation.pagipetang.PagiActivity
import com.zfadhil.doandzikrapp.presentation.pagipetang.PetangActivity

class PagiPetangActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityPagiPetangBinding? = null
    private val binding get() = _binding as ActivityPagiPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.txt_dzikir_pagi_petang)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityPagiPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnPagi: ImageButton = findViewById(R.id.img_btn_dzikir_pagi)
        val btnPetang: ImageButton = findViewById(R.id.img_btn_dzikir_petang)

        btnPagi.setOnClickListener(this)
        btnPetang.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, PagiActivity::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(Intent(this, PetangActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
