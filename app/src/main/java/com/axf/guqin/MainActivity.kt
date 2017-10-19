package com.axf.guqin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
import com.davemorrissey.labs.subscaleview.ImageSource
import com.github.piasy.biv.view.BigImageView
import com.q42.android.scrollingimageview.ScrollingImageView
import java.io.InputStream
import java.net.URL

import java.util.Timer
import java.util.TimerTask
import android.os.StrictMode
import android.graphics.BitmapRegionDecoder
import android.graphics.Rect


class MainActivity : AppCompatActivity(),OnClickListener {


    private var mImgBtn: ImageButton? = null
    private var mBtnTest:Button? = null
    private var mBigImage:BigImageView? = null
    private val imgURL = "http://ww1.sinaimg.cn/mw690/005Fj2RDgw1f9mvl4pivvj30c82ougw3.jpg"

    final val r:Runnable = Runnable { run { mBigImage?.scrollBy(0,2);Handler().postDelayed(r,100) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        BigImageViewer.initialize(FrescoImageLoader.with(applicationContext));
        setContentView(R.layout.activity_main)

        mBigImage = findViewById<BigImageView>(R.id.mBigImage)
        mImgBtn = findViewById<ImageButton>(R.id.imgBtn)

        mImgBtn?.setOnClickListener(this)

        val inputIs:InputStream = URL(imgURL).openStream()

        val tmpOptions = BitmapFactory.Options()
        tmpOptions.inJustDecodeBounds = true
        BitmapFactory.decodeStream(inputIs, null, tmpOptions)
        val width = tmpOptions.outWidth
        val height = tmpOptions.outHeight


        val bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputIs, false)
        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.RGB_565
        val bitmap = bitmapRegionDecoder.
                decodeRegion(Rect(width / 2 - 100, height / 2 - 100, width / 2 + 100, height / 2 + 100), options)

//        val bm:Bitmap = BitmapFactory.decodeStream(inputIs)
        mBigImage?.ssiv?.setImage(ImageSource.bitmap(bitmap))
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.imgBtn) {
            Handler().postDelayed(r,500)
        }
    }
}