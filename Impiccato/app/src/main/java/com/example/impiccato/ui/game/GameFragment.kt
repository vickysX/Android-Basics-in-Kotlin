package com.example.impiccato.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.impiccato.R
import com.example.impiccato.databinding.FragmentGameBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GameFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gameViewModel = viewModel
        binding.maxNoOfWrongGuesses = MAX_NO_OF_WRONG_GUESSES
        binding.lifecycleOwner = viewLifecycleOwner
        binding.skipWord.setOnClickListener { showSkipDialog() }
        binding.submitGuess.setOnClickListener { submitGuess() }
    }

    private fun submitGuess() {
        if (viewModel.game()) {
            val playerLetter: Char = binding.inputLetter.text!![0]
            //viewModel.guess(playerLetter)
            if (viewModel.isUserGuessCorrect(playerLetter)) {
                viewModel.updateTempWord(playerLetter)
                setErrorTextField(false)
            } else {
                setErrorTextField(true)
            }
        } else {
            if (viewModel.victory())
                showFinalWinDialog()
            else showFinalLostDialog()
        }
    }

    private fun restartGame() {
        viewModel.reinitializeData()
        setErrorTextField(false)
    }

    private fun exitGame() {
        activity?.finish()
    }

    private fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.inputBox.isErrorEnabled = true
            binding.inputBox.error = getString(R.string.error)
        } else {
            binding.inputBox.isErrorEnabled = false
        }
        binding.inputLetter.text = null
    }

    private fun showFinalWinDialog() {
        MaterialAlertDialogBuilder(this.requireContext())
            .setTitle(getString(R.string.you_won, viewModel.guesses.value))
            .setMessage(R.string.dialog_message)
            .setNegativeButton(R.string.exit_game) { _, _ ->
               exitGame()
            }
            .setPositiveButton(R.string.restart_game) { _, _ ->
               restartGame()
            }
            .show()
    }

    private fun showFinalLostDialog() {
        MaterialAlertDialogBuilder(this.requireContext())
            .setTitle(R.string.you_lost)
            .setMessage(getString(R.string.dialog_skip_error_message, viewModel.currentWord, getString(R.string.dialog_message)))
            .setNegativeButton(R.string.exit_game) { _, _ ->
                exitGame()
            }
            .setPositiveButton(R.string.restart_game) { _, _ ->
                restartGame()
            }
            .show()
    }

    private fun showSkipDialog() {
        MaterialAlertDialogBuilder(this.requireContext())
            .setTitle(R.string.skip)
            .setMessage(getString(R.string.dialog_skip_error_message, viewModel.currentWord, getString(R.string.dialog_message)))
            .setNegativeButton(R.string.exit_game) { _, _ ->
                exitGame()
            }
            .setPositiveButton(R.string.restart_game) { _, _ ->
                restartGame()
            }
            .show()
    }
}