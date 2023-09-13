package com.zfadhil.doandzikrapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.card.MaterialCardView
import com.zfadhil.doandzikrapp.databinding.ActivityMainBinding
import com.zfadhil.doandzikrapp.model.ArticleItem
import com.zfadhil.doandzikrapp.presentation.DetailArticleActivity
import com.zfadhil.doandzikrapp.presentation.DzikirHarianActivity
import com.zfadhil.doandzikrapp.presentation.DzikirSetiapSaatActivity
import com.zfadhil.doandzikrapp.presentation.QauliyahSholatActivity
import com.zfadhil.doandzikrapp.utils.OnItemCallBack


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var dotSliderIndicator = arrayOf<ImageView?>()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback(){
        // instance onPageSelected give you access to setting behavior state of selected page
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            for (i in initData().indices){
                Toast.makeText(this@MainActivity, "Page $position", Toast.LENGTH_LONG).show()
                dotSliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.inactive_dot)
                )
            }
            dotSliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext,R.drawable.active_dot)

            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        initView()
        setupViewPager()
    }

    private fun initView() {
        // setContentView() is use to choose and display layout in activity
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // declare variable to get in touch with view in layout activity_main
        // use findViewId to communicate with the view
        val cardQauliyahSholat = findViewById<MaterialCardView>(R.id.card_qauliyah_sholat)
        val cardDzikir = findViewById<MaterialCardView>(R.id.card_dzikir)
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.card_dzikir_harian)
        val cardDzikirPagiPetang = findViewById<MaterialCardView>(R.id.card_pagi_petang)
        // when cardview clicked it will navigate to other page
        // Intent is use for navigate to other activity by clicking cardview
        cardQauliyahSholat.setOnClickListener {
            // Intent(argument context, activity you want to go)
            val intent = Intent(this, QauliyahSholatActivity::class.java)
            // start to go to destination activity
            startActivity(intent)
        }

        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardDzikirPagiPetang.setOnClickListener(this)

        val mAdapter = ArticleAdapter()
        mAdapter.setData(initData() )
        mAdapter.setOnItemCallback(object : OnItemCallBack {
            override fun onItemClicked(item: ArticleItem) {
                val intent = Intent(applicationContext, DetailArticleActivity::class.java)
                // navigate do DetailArticleActivity with data using putExtra
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_TITLE,item.titleArticle)
                intent.putExtra("content",item.contentArticle)
                intent.putExtra("image",item.imageArticle)
                startActivity(intent)
            }

        })
        binding.vpArticle.adapter = mAdapter
        binding.vpArticle.registerOnPageChangeCallback(slidingCallback)

    }

    private fun initData() : MutableList<ArticleItem> {
        val titleArticle = resources.getStringArray(R.array.arr_title_artikel)
        val contentArticle = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArticle = resources.obtainTypedArray(R.array.arr_img_artikel)

        val listData = mutableListOf<ArticleItem>()
        for (i in titleArticle.indices){
            val data = ArticleItem(
                titleArticle[i],
                imageArticle.getResourceId(i,0),
                contentArticle[i]
            )
            listData.add(data)
        }
        imageArticle.recycle()
        return listData
    }

    private fun setupViewPager() {
        dotSliderIndicator = arrayOfNulls(initData().size)

        for (i in initData().indices){
            dotSliderIndicator[i] = ImageView(this)
            dotSliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(this,R.drawable.inactive_dot)
            )

            val params = LinearLayoutCompat.LayoutParams(35,35)
            params.marginStart = 8
            params.marginEnd = 8
            binding.dots.addView(dotSliderIndicator[i], params)

        }
    }

    override fun onClick(view: View?) {
        when(view?. id) {
            R.id.card_dzikir -> startActivity(Intent(this, DzikirSetiapSaatActivity::class.java))
            R.id.card_dzikir_harian -> startActivity(Intent(this, DzikirHarianActivity::class.java))
            R.id.card_pagi_petang -> startActivity(Intent(this, PagiPetangActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}