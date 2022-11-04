package com.caiquebrener.hqawesome.ui.hq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.caiquebrener.hqawesome.R
import com.caiquebrener.hqawesome.data.actions.HQItemListener
import com.caiquebrener.hqawesome.databinding.FragmentItemListBinding
import com.caiquebrener.hqawesome.placeholder.PlaceholderContent
import com.caiquebrener.hqawesome.ui.hq.recyclerview.MyHQRecyclerViewAdapter
import com.caiquebrener.hqawesome.ui.viewmodel.HQViewModel
import kotlinx.coroutines.flow.combine


class HQFragment : Fragment(), HQItemListener {

    private lateinit var adapter: MyHQRecyclerViewAdapter
    private val viewModel by navGraphViewModels<HQViewModel>(R.id.nav_graph) { defaultViewModelProviderFactory }

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentItemListBinding.inflate(inflater)
        val view = binding.root as RecyclerView

        adapter = MyHQRecyclerViewAdapter(this)

        view.apply {
            this.adapter = this@HQFragment.adapter
            this.layoutManager = LinearLayoutManager(context)
        }
        initObserver()
        return view
    }

    private fun initObserver() {
        viewModel.hqListLivedate.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }

        viewModel.navigationToDetailsLiveData.observe(viewLifecycleOwner){
            val action = HQFragmentDirections.actionHqFragmentToHQDetails()
            findNavController().navigate(action)
        }
    }

    override fun onItemSelected(position: Int) {
        viewModel.onHQSelected(position)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            HQFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }


}