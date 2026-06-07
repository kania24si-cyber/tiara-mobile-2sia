package com.example.tiara_distinctive.Tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiara_distinctive.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding:
            ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityTutorialBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val fragmentsList = listOf(

            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )

        val adapter =
            TutorialFragmentAdapter(
                this,
                fragmentsList
            )

        binding.viewPager.adapter = adapter

        binding.dotIndicator.attachTo(
            binding.viewPager
        )
    }
}