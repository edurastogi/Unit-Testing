package unittest.data;

import org.springframework.data.jpa.repository.JpaRepository;
import unittest.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
