package com.concretepage.jewelry.dao;
import java.util.List;
import com.concretepage.jewelry.entity.Jewelry;

public interface JewelryDAO {
    List<Jewelry> getAllJewelry();
    Jewelry getJewelryByBarCode(String barCode);
    void addJewelry(Jewelry jewelry);
    void updateJewelry(Jewelry jewelry);
    void deleteJewelry(String barCode);
    boolean jewelryExists(String barCode);
}
 