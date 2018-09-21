package unittest.business;

import org.springframework.stereotype.Component;
import unittest.model.Item;

@Component
public class ItemBusinessService {
    public Item retreiveHardcodedItem() {
        return new Item(1,"Ball",10,100);
    }
}
