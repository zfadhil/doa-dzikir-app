package com.zfadhil.doandzikrapp.utils

import com.zfadhil.doandzikrapp.model.ArticleItem

interface OnItemCallBack {
    fun onItemClicked (item: ArticleItem)
}