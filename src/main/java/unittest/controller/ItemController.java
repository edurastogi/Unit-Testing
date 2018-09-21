package unittest.controller;

import unittest.business.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unittest.model.Item;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1,"Ball",10,100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        //return new Item(1,"Ball",10,100);
        return businessService.retreiveHardcodedItem();
    }
}
