package com.airbnb.lottie.issues

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.issues.databinding.IssueReproActivityBinding

class IssueReproActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = IssueReproActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.animationView1Top) {
            progress = 1.0f
        }

        with(binding.animationView2Bottom) {
            setMaxProgress(1.0f)
            progress = 1.0f
        }

        with(binding.root) {
            postOnAnimationDelayed(Runnable {
                Log.d(TAG, "binding.animationView1Top.progress = ${binding.animationView1Top.progress}")
                /**
                 * Logs will print D/IssueReproActivity: binding.animationView1Top.progress = 0.9914648 for above progress.
                 */
                Log.d(TAG, "binding.animationView2Bottom.progress = ${binding.animationView2Bottom.progress}")
            }, 5000)
        }
    }

    companion object {
        const val TAG = "IssueReproActivity"
    }
}
