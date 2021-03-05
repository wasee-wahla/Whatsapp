package com.notin.whatsapp.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ChatViewModel @Inject constructor() : ViewModel() {

    val mutableLiveData = MutableLiveData<List<String>>()

    fun getFakeData() {
        val arrayList: ArrayList<String> = ArrayList()
        arrayList.add("Ali")
        arrayList.add("Awais")
        arrayList.add("Ahmad")
        arrayList.add("Asif")
        arrayList.add("Adnan")
        arrayList.add("Hani")
        arrayList.add("Naeem")
        arrayList.add("Basit")
        arrayList.add("Nadeem")
        arrayList.add("Ahmad")
        arrayList.add("Hani")
        arrayList.add("Adnan")
        arrayList.add("Asif")
        arrayList.add("Nadeem")
        arrayList.add("Naeem")
        arrayList.add("Nadeem")
        mutableLiveData.value = arrayList
    }

}