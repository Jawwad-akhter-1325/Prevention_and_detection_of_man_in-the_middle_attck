package com.ismproj.sslpin

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bindImage(ivProfile: ImageView, imgUrl: String?) {
    ivProfile.let {
        Glide.with(ivProfile.context)
            .load("https://vitaccess.tech/images?name=" + imgUrl)
            .into(ivProfile)
    }
}