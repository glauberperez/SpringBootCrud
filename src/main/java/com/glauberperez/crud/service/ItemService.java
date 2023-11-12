package com.glauberperez.crud.service;

import com.glauberperez.crud.model.ItemModel;

import java.util.List;

public interface ItemService {

    List<ItemModel> GetItems();
    void CreateItem(ItemModel Item);
    void EditItem(Long id, String Name);
    void DeleteItem(Long Id);


}
