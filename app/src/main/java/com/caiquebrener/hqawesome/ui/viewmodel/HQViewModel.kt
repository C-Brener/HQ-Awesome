package com.caiquebrener.hqawesome.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caiquebrener.hqawesome.data.model.HQDetails
import com.caiquebrener.hqawesome.placeholder.PlaceholderContent

class HQViewModel : ViewModel() {

    private val _hqDetailsLivedata: MutableLiveData<HQDetails> = MutableLiveData()
    val hqDetailsLivedata: LiveData<HQDetails> = _hqDetailsLivedata

    private val _hqListLivedata: MutableLiveData<MutableList<PlaceholderContent.PlaceholderItem>> =
        MutableLiveData()
    val hqListLivedate: LiveData<MutableList<PlaceholderContent.PlaceholderItem>> = _hqListLivedata

    private val _navigationToDetailsLiveData: MutableLiveData<Unit> = MutableLiveData()
    val navigationToDetailsLiveData:LiveData<Unit> = _navigationToDetailsLiveData


    fun onHQSelected(position: Int) {
        val hqDetails =
            HQDetails("Minha HQ", "Olá, bem vindo ao universo marvel")

        _hqDetailsLivedata.postValue(hqDetails)
        _navigationToDetailsLiveData.postValue(Unit)
    }


    init {
        _hqListLivedata.postValue(PlaceholderContent.ITEMS)
    }
}