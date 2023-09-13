package com.zfadhil.doandzikrapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zfadhil.doandzikrapp.DoaDzikirAdapter
import com.zfadhil.doandzikrapp.R
import com.zfadhil.doandzikrapp.databinding.ActivityPetangBinding
import com.zfadhil.doandzikrapp.model.DataDoaDzikir

class PetangActivity : AppCompatActivity() {
    private var _binding: ActivityPetangBinding? = null
    private val binding get() = _binding as ActivityPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.txt_dzikir_petang)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPetang.apply {
            val mAdapter = DoaDzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPetang())
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@PetangActivity)
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