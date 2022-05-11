package com.example.impiccato.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var _currentWord= MutableLiveData<String>()
    val currentWord: LiveData<String> get() = _currentWord

    private var _wrongGuesses = MutableLiveData<Int>(0)
    val wrongGuesses: LiveData<Int> get() = _wrongGuesses

    private var _guesses = MutableLiveData<Int>(0)
    val guesses: LiveData<Int> get() = _guesses

    private var _tempWord = MutableLiveData<String>()
    val tempWord: LiveData<String> get() = _tempWord

    private val usedWords = mutableListOf<String>()


    init {
        getWord()
    }

    fun getWord() {
        _currentWord.value = allWordsList.random()
        while (usedWords.contains(currentWord.value)) {
            _currentWord.value = allWordsList.random()
        }
        usedWords.add(currentWord.value!!)
        _tempWord.value = ("_ ").repeat(currentWord.value!!.length)
    }

    fun isUserGuessCorrect(playerLetter: Char): Boolean {
        _guesses.value = _guesses.value!!.inc()
        if (currentWord.value!!.contains(playerLetter, true)) {
            return true
        }
        _wrongGuesses.value = _wrongGuesses.value!!.inc()
        return false
    }

    fun updateTempWord(playerLetter: Char) {
        var temp = StringBuilder(_tempWord.value!!)
        Log.d("GameViewModel", "temp length: ${temp.length}")
        Log.d("GameViewModel", "word length: ${_currentWord.value!!.length}")
        var ind = _currentWord.value!!.indexOf(playerLetter, 0, true)
        Log.d("GameViewModel", "ind: ${ind}")
        temp[ind * 2] = playerLetter
        while (_currentWord.value!!.substring(ind + 1).contains(playerLetter)) {
            ind = _currentWord.value!!.indexOf(playerLetter, ind + 1, true)
            temp[ind * 2] = playerLetter
        }
        _tempWord.value = temp.toString()
    }

    fun game(): Boolean {
        return tempWord.value!!.contains('_') && wrongGuesses.value!! < MAX_NO_OF_WRONG_GUESSES
    }

    fun victory(): Boolean {
        if (!tempWord.value!!.contains('_') && wrongGuesses.value!! < MAX_NO_OF_WRONG_GUESSES) return true
        return false
    }

    fun reinitializeData() {
        _wrongGuesses.value = 0
        _guesses.value = 0
        getWord()
        //_tempWord.value = ("_ ").repeat(_currentWord.value!!.length)
    }
}