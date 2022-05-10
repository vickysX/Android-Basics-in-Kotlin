package com.example.impiccato.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private lateinit var _currentWord: String
    val currentWord get() = _currentWord

    private var _wrongGuesses = MutableLiveData<Int>(0)
    val wrongGuesses: LiveData<Int> get() = _wrongGuesses

    private var _guesses = MutableLiveData<Int>(0)
    val guesses: LiveData<Int> get() = _guesses

    private var _tempWord = MutableLiveData<CharSequence>(("_ ").repeat(currentWord.length))
    val tempWord: LiveData<CharSequence> get() = _tempWord

    private val usedWords = mutableListOf<String>()

    fun getWord() {
        _currentWord = allWordsList.random()
        while (usedWords.contains(currentWord)) {
            _currentWord = allWordsList.random()
        }
        usedWords.add(currentWord)
    }

    fun guess(playerLetter: Char) {}
}