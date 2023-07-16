package com.example.homework1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework1.databinding.ActivityMainBinding
import com.example.homework1.databinding.FragmentBlank1Binding
import com.example.homework1.databinding.FragmentBlank2Binding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val fragmentLayout2 = BlankFragment2()
            val fragmentLayout1 = BlankFragment1()
            fragmentIdReplace.setOnClickListener {
                if (fragmentIdReplace.text.equals("1-fragment")) {
                    val fragmentManager = supportFragmentManager
                    fragmentManager.beginTransaction().remove(fragmentLayout1)
                        .commit()
                    fragmentManager.beginTransaction().replace(R.id.container, fragmentLayout2)
                        .show(fragmentLayout2)
                        .commit()

                    fragmentIdReplace.text="2-fragment"
                } else if (fragmentIdReplace.text.equals("2-fragment")) {
                    val fragmentManager = supportFragmentManager
                    fragmentManager.beginTransaction().remove(fragmentLayout2)
                        .commit()

                    fragmentManager.beginTransaction().replace(R.id.container, fragmentLayout1)
                        .show(fragmentLayout1)
                        .commit()

                    fragmentIdReplace.text="1-fragment"
                }
            }
            fragmentIdShow.setOnClickListener{
                val fragmentManager = supportFragmentManager
                fragmentManager.beginTransaction().show(fragmentLayout1).commit()
                fragmentManager.beginTransaction().show(fragmentLayout2).commit()
            }
            fragmentIdHide.setOnClickListener{
                val fragmentManager = supportFragmentManager
                fragmentManager.beginTransaction().hide(fragmentLayout1).commit()
                fragmentManager.beginTransaction().hide(fragmentLayout2).commit()
            }
        }
    }
}
