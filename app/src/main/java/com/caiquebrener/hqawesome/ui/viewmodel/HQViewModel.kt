package com.caiquebrener.hqawesome.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.caiquebrener.hqawesome.data.model.HQDetails

class HQViewModel : ViewModel() {

    fun loadHQDetails():HQDetails = HQDetails("Minha HQ", "Olá, bem vindo ao universo marvel")
}