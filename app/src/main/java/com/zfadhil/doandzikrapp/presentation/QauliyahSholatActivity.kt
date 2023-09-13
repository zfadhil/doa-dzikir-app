package com.zfadhil.doandzikrapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zfadhil.doandzikrapp.DoaDzikirAdapter
import com.zfadhil.doandzikrapp.R
import com.zfadhil.doandzikrapp.model.DataDoaDzikir.listQauliyah
import com.zfadhil.doandzikrapp.databinding.ActivityQauliyahSholatBinding

class QauliyahSholatActivity : AppCompatActivity() {

    private var _binding: ActivityQauliyahSholatBinding? = null
    private val binding get() = _binding as ActivityQauliyahSholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.txt_menu_qaubliyah_sholat)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityQauliyahSholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(listQauliyah)
        binding.rvQauliyahSholat.adapter = mAdapter
        binding.rvQauliyahSholat.layoutManager = LinearLayoutManager(this)
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