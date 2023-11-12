package com.glauberperez.crud.controller;


import com.glauberperez.crud.model.ItemModel;
import com.glauberperez.crud.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String index(Model model){
        ItemModel Item = new ItemModel();
        model.addAttribute("listItems", itemService.GetItems());
       model.addAttribute("item", Item);
        return "index";
    }

    @PostMapping("/")
    public String saveItem(@ModelAttribute("item") ItemModel item){
        itemService.CreateItem(item);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id){
        itemService.DeleteItem(id);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editItem(@PathVariable Long id,@RequestBody String Name){
        Name = Name.split("=")[1];
        System.out.println(Name);
        itemService.EditItem(id, Name);
        return "redirect:/";
    }

}
