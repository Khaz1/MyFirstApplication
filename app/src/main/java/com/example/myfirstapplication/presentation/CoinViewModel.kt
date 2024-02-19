package com.example.myfirstapplication.presentation

import androidx.lifecycle.ViewModel
import com.example.myfirstapplication.domain.GetCoinInfoListUseCase
import com.example.myfirstapplication.domain.GetCoinInfoUseCase
import com.example.myfirstapplication.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase,
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}
