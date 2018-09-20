package unittest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unittest.model.Item;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item helloWorld(){

        return new Item(1,"Ball",10,100);
    }
}
