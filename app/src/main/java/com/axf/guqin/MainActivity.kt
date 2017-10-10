package com.axf.guqin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import com.github.piasy.biv.BigImageViewer
import com.github.piasy.biv.loader.fresco.FrescoImageLoader
import android.view.View.OnClickListener
import android.widget.Button
import com.github.piasy.biv.view.BigImageView

import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity(),OnClickListener {

    private var mBigImage: BigImageView? = null
    private var mImgBtn: ImageButton? = null
    private var mBtnTest:Button? = null


    final val r:Runnable = Runnable { run { mBigImage?.scrollBy(0,2);Handler().postDelayed(r,100) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BigImageViewer.initialize(FrescoImageLoader.with(applicationContext));
        setContentView(R.layout.activity_main)

        mBigImage = findViewById<BigImageView>(R.id.mBigImage)
        mImgBtn = findViewById<ImageButton>(R.id.imgBtn)

        mImgBtn?.setOnClickListener(this)

        mBigImage?.showImage(Uri.parse("http://ww1.sinaimg.cn/mw690/005Fj2RDgw1f9mvl4pivvj30c82ougw3.jpg"))
        Handler().postDelayed(r,500)
    }


    override fun onClick(v: View?) {
        if(v?.id == R.id.imgBtn) {
            Handler().postDelayed(r,500)
        }
    }
}
