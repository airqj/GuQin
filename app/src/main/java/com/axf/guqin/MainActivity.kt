package com.axf.guqin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import com.github.piasy.biv.BigImageViewer
import com.github.piasy.biv.loader.fresco.FrescoImageLoader
import android.view.View.OnClickListener
import android.view.View.OnTouchListener
import com.github.piasy.biv.view.BigImageView

class MainActivity : AppCompatActivity(),OnClickListener {

    private var mBigImage: BigImageView? = null
    private var mImgBtn: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BigImageViewer.initialize(FrescoImageLoader.with(applicationContext));
        setContentView(R.layout.activity_main)

        mBigImage = findViewById<BigImageView>(R.id.mBigImage)
        mImgBtn = findViewById<ImageButton>(R.id.imgBtn)

        mImgBtn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.imgBtn) {
            mBigImage?.showImage(Uri.parse("http://ww1.sinaimg.cn/mw690/005Fj2RDgw1f9mvl4pivvj30c82ougw3.jpg"))
        }
    }

}
