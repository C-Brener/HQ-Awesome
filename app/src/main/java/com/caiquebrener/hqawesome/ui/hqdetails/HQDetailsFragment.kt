package com.caiquebrener.hqawesome.ui.hqdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.navGraphViewModels
import com.caiquebrener.hqawesome.R
import com.caiquebrener.hqawesome.data.model.HQDetails
import com.caiquebrener.hqawesome.databinding.FragmentHqDetailsBinding
import com.caiquebrener.hqawesome.ui.viewmodel.HQViewModel

class HQDetailsFragment : Fragment() {
    private val viewModel by navGraphViewModels<HQViewModel>(R.id.nav_graph) { defaultViewModelProviderFactory }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding:FragmentHqDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_hq_details,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        return binding.root
    }

}