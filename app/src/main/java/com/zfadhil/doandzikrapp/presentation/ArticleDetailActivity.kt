package com.zfadhil.doandzikrapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zfadhil.doandzikrapp.R
import com.zfadhil.doandzikrapp.databinding.ActivityArticleDetailBinding

class ArticleDetailActivity : AppCompatActivity() {
    private var _binding : ActivityArticleDetailBinding? = null
    private val binding = _binding as ActivityArticleDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleArticle = intent.getStringExtra("title")
        val contentArticle = intent.getStringExtra("content")
        val imageArticle = intent.getIntExtra("image",1)

        binding.apply {

        }
    }

}