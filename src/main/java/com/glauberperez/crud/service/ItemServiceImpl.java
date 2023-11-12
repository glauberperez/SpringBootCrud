package com.glauberperez.crud.service;

import com.glauberperez.crud.model.ItemModel;
import com.glauberperez.crud.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemModel> GetItems() {
        return itemRepository.findAll();
    }

    @Override
    public void CreateItem(ItemModel Item) {
        itemRepository.save(Item);
    }

    @Override
    public void EditItem(Long id, String Name) {
        ItemModel item = itemRepository.findById(id).get();
        item.setName(Name);
        itemRepository.save(item);
    }

    @Override
    public void DeleteItem(Long Id) {
        itemRepository.deleteById(Id);
    }
}
