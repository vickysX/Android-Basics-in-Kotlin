package com.example.impiccato.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var _currentWord= MutableLiveData(allWordsList.random())
    val currentWord: LiveData<String> get() = _currentWord

    private var _wrongGuesses = MutableLiveData<Int>(0)
    val wrongGuesses: LiveData<Int> get() = _wrongGuesses

    private var _guesses = MutableLiveData<Int>(0)
    val guesses: LiveData<Int> get() = _guesses

    private var _tempWord = MutableLiveData(("_ ").repeat(currentWord.value!!.length - 1))
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
        val temp = StringBuilder(_tempWord.value!!)
        var ind = currentWord.value!!.indexOf(playerLetter, 0, true)
        temp[ind * 2] = playerLetter
        while (currentWord.value!!.substring(ind + 1).contains(playerLetter)) {
            ind = currentWord.value!!.indexOf(playerLetter, ind + 1, true)
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
        _currentWord.value = allWordsList.random()
        getWord()
        _tempWord.value = ("_ ").repeat(currentWord.value!!.length - 1)
    }
}