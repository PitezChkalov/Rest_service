package com.concretepage.jewelry.service;

import com.concretepage.jewelry.entity.Jewelry;

import java.util.List;


public interface JewelryService {
     List<Jewelry> getAllJewelry();
     Jewelry getJewelryByBarCode(String barCode);
     boolean addJewelry(Jewelry jewelry);
     void updateJewelry(Jewelry jewelry);
     void deleteJewelry(String barCode);

}
