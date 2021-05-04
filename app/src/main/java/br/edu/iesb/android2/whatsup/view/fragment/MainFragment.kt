package br.edu.iesb.android2.whatsup.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.iesb.android2.whatsup.R
import br.edu.iesb.android2.whatsup.domain.*
import br.edu.iesb.android2.whatsup.view.adapter.MyItemRecyclerViewAdapter
import br.edu.iesb.android2.whatsup.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var userData: UserData
    private lateinit var basalData: BasalData
    var resp: ArrayList<Retorno> = ArrayList()

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        userData = UserData()
        basalData = BasalData()

        view.btSend.setOnClickListener { view ->

            val question = etQuestion.text.toString() ?: "Oi"
            val message = Message(question, "", "123")

//            Log.d("TESTE_WHATSUP", "evento click do botão enviar")
            viewModel.run { load(message, userData, basalData, resp) }
            viewModel.responseView.observe(viewLifecycleOwner) {response ->
                if (response.isNotEmpty()){
                    load(response)
                    etQuestion.setText("")
                }
            }
        }
        return view
    }

    private fun load(callback: List<Retorno>?) {
        rvMainChat.adapter = MyItemRecyclerViewAdapter(callback)
        rvMainChat.layoutManager = LinearLayoutManager(this.context)
        rvMainChat.setHasFixedSize(true)
    }
}