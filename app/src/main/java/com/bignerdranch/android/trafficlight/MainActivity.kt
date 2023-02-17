package com.bignerdranch.android.trafficlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bignerdranch.android.trafficlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isStop = true
    private var isGo = false
    private var isWait = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.redlight.visibility = View.VISIBLE
        binding.yellowlight.visibility = View.INVISIBLE
        binding.greenlight.visibility = View.INVISIBLE

        binding.button.setText(R.string.redlight)
        binding.button.setBackgroundColor(getColor(R.color.red))

        binding.button.setOnClickListener {
            if (isStop) {
                binding.button.setBackgroundColor(getColor(R.color.green))
                binding.button.setText(R.string.greenlight)

                binding.redlight.visibility = View.INVISIBLE
                binding.greenlight.visibility = View.VISIBLE

                isStop = false
                isGo = true

            } else if (isGo) {
                binding.button.setBackgroundColor(getColor(R.color.yellow))
                binding.button.setText(R.string.yellowlight)

                binding.greenlight.visibility = View.INVISIBLE
                binding.yellowlight.visibility = View.VISIBLE

                isGo = false
                isWait = true

            } else {
                binding.button.setBackgroundColor(getColor(R.color.red))
                binding.button.setText(R.string.redlight)

                binding.yellowlight.visibility = View.INVISIBLE
                binding.redlight.visibility = View.VISIBLE

                isWait = false
                isStop = true

            }
        }
    }
}