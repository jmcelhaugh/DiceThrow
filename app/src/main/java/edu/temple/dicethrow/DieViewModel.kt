package edu.temple.dicethrow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel: ViewModel() {

    private var dieSides = 6

    private var rolledNum: MutableLiveData<Int> = MutableLiveData()

    fun setSides(sides: Int){
        if(sides > 0){
            dieSides = sides
        }
    }

    fun rollDie(){
        rolledNum.value = (Random.nextInt(dieSides) + 1)
    }

    fun getRoll() : MutableLiveData<Int>{
        return rolledNum
    }
}