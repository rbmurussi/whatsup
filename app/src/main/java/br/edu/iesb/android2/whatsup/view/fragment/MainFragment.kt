package br.edu.iesb.android2.whatsup.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.iesb.android2.whatsup.R
import br.edu.iesb.android2.whatsup.domain.ItemResult
import br.edu.iesb.android2.whatsup.view.adapter.MyItemRecyclerViewAdapter
import br.edu.iesb.android2.whatsup.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
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