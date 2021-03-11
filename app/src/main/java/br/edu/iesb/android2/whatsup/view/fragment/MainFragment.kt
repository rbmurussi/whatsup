package br.edu.iesb.android2.whatsup.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.edu.iesb.android2.whatsup.R
import br.edu.iesb.android2.whatsup.domain.ItemResult
import br.edu.iesb.android2.whatsup.util.Endpoint
import br.edu.iesb.android2.whatsup.util.NetworkUtils
import br.edu.iesb.android2.whatsup.view.adapter.MyItemRecyclerViewAdapter
import br.edu.iesb.android2.whatsup.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        viewModel.run { load() }
        viewModel.responseView.observe(viewLifecycleOwner) {response ->
            if (response.isNotEmpty()){
                load(response)
            }
        }
        return view
    }

    private fun load(callback: List<ItemResult>?) {
        rvMainChat.adapter = MyItemRecyclerViewAdapter(callback)
        rvMainChat.layoutManager = LinearLayoutManager(this.context)
        rvMainChat.setHasFixedSize(true)
    }
}