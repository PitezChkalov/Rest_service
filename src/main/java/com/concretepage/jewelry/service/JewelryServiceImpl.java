package com.concretepage.jewelry.service;

import com.concretepage.jewelry.dao.JewelryDAO;
import com.concretepage.jewelry.entity.Jewelry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryServiceImpl implements JewelryService {
	@Autowired
	private JewelryDAO jewelryDAO;
	@Override
	public Jewelry getJewelryByBarCode(Long barCode) {
		Jewelry obj = jewelryDAO.getJewelryByBarCode(barCode);
		return obj;
	}	
	@Override
	public List<Jewelry> getAllJewelry(){
		return jewelryDAO.getAllJewelry();
	}
	@Override
	public synchronized boolean addJewelry(Jewelry jewelry){
       if (jewelryDAO.jewelryExists(jewelry.getBarCode())) {
    	   return false;
       } else {
    	   jewelryDAO.addJewelry(jewelry);
    	   return true;
       }
	}
	@Override
	public void updateJewelry(Jewelry jewelry) {
		jewelryDAO.updateJewelry(jewelry);
	}
	@Override
	public void deleteJewelry(Long barCode) {
		jewelryDAO.deleteJewelry(barCode);
	}

}
