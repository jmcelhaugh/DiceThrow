package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dieViewModel = ViewModelProvider(this)[DieViewModel::class.java]
        dieViewModel.setSides(6)
        dieViewModel.rollDie()

        val fragment1 = DieFragment()

        if(savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, fragment1)
                .commit()

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieViewModel.rollDie()
        }

    }

}