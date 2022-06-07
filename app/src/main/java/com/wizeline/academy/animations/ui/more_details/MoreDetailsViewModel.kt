package com.wizeline.academy.animations.ui.more_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wizeline.academy.animations.core.data.repository.LoreIpsumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoreDetailsViewModel @Inject constructor(private var repository: LoreIpsumRepository) :
    ViewModel() {

    val title: LiveData<String>
        get() = _title

    private val _title = MutableLiveData<String>()

    val content: LiveData<String>
        get() = _content

    private val _content = MutableLiveData<String>()

    fun fetchData(index: Int) {
        fetchTitle(index)
        fetchContent(index)
    }

    private fun fetchTitle(index: Int) {
        val title = repository.getTitle(index)
        _title.postValue(title)
    }

    private fun fetchContent(index: Int) {
        val content = repository.getContent(index)
        _content.postValue(content)
    }
}