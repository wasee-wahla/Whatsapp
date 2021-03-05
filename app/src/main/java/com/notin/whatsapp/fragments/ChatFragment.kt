package com.notin.whatsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.notin.whatsapp.R
import com.notin.whatsapp.adapters.ChatAdapter
import com.notin.whatsapp.vm.ChatViewModel
import kotlinx.android.synthetic.main.fragment_chat.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment() {

    @Inject
    lateinit var chatAdapter: ChatAdapter

    @Inject
    lateinit var viewModel: ChatViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        viewModel.getFakeData()
        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
            chatAdapter = ChatAdapter(it as ArrayList<String>)
            chatRecyclerView.layoutManager = LinearLayoutManager(view.context)
            chatRecyclerView.adapter = chatAdapter
        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */

        @JvmStatic
        fun newInstance() =
            ChatFragment().apply {

            }
    }
}