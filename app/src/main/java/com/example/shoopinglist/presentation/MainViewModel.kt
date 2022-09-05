package com.example.shoppingList.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppingList.data.ShopListRepositoryImpl
import com.example.shoppingList.domain.DeleteShopItemUseCase
import com.example.shoppingList.domain.EditShopItemUseCase
import com.example.shoppingList.domain.GetShopListUseCase
import com.example.shoppingList.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}
