package com.xynos.pikachu_loader

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.xynos.pikachu_loader.databinding.ActivityPikachuLoaderBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PikachuLoader : AppCompatActivity() {

    private lateinit var binding: ActivityPikachuLoaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate: ")
        //finishActivityIfNeeded()
        super.onCreate(savedInstanceState)
        binding = ActivityPikachuLoaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activity = this
        loadImage()
    }

    private fun loadImage() {
        Log.i(TAG, "loadImage: ")
        Glide.with(this)
            .asGif()
            .load(R.drawable.pikachu_running)
            .into(binding.image)
    }

    private fun finishActivityIfNeeded() {
        if (needToFinish) {
            Log.i(TAG, "finishActivityIfNeeded: ")
            lifecycleScope.launch {
                activity = null
                delay(1000)
                finish()
            }
            return
        }
    }

    override fun onResume() {
        finishActivityIfNeeded()
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        activity = null
    }

    companion object {
        private var activity: PikachuLoader? = null
        private var needToFinish = true

        fun show(context: Context) {
            Log.i(TAG, "show: ")
            val intent = Intent(context, PikachuLoader::class.java)
            needToFinish = false
            context.startActivity(intent)
        }

        fun dismiss() {
            Log.i(TAG, "dismiss: ")
            needToFinish = true
            activity?.finish()
        }

        private const val TAG = "PikachuLoader"

    }
}


