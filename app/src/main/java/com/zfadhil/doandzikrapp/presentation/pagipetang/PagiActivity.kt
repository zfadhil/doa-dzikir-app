package com.zfadhil.doandzikrapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zfadhil.doandzikrapp.DoaDzikirAdapter
import com.zfadhil.doandzikrapp.R
import com.zfadhil.doandzikrapp.databinding.ActivityPagiBinding
import com.zfadhil.doandzikrapp.model.DataDoaDzikir

class PagiActivity : AppCompatActivity() {
    private var _binding: ActivityPagiBinding? = null
    private val binding get() = _binding as ActivityPagiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.dzikir_pagi)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPagi.apply {
            val mAdapter = DoaDzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPagi())
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@PagiActivity)
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