package com.example.madlevel5task1.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.madlevel5task1.R
import kotlinx.android.synthetic.main.fragment_note_pad.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NotePadFragment : Fragment() {
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_pad, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // view.findViewById<Button>(R.id.button_first).setOnClickListener {
        //    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
       // }
        observeAddNoteResult()
    }

    @SuppressLint("StringFormatInvalid")
    private fun observeAddNoteResult() {
        viewModel.note.observe(viewLifecycleOwner, Observer { note ->
            note?.let {

                tvNoteTitle.text = it.title
                tvLastUpdated.text = getString(R.string.last_updated, it.lastUpdate.toString())
                tvNoteText.text = it.text


            }
        })
    }

}