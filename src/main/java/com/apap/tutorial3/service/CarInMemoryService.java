package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import com.apap.tutorial3.model.CarModel;
import org.springframework.stereotype.Service;

@Service
public class CarInMemoryService implements CarService{
	private List<CarModel> archiveCar;
	
	public CarInMemoryService() {
		archiveCar = new ArrayList<>();
	}
	
	public void addCar(CarModel car) {
		archiveCar.add(car);
	}
	
	public List<CarModel> getCarList(){
		return archiveCar;
	}
	
	public CarModel getCarDetail(String id) {
		CarModel car= null;
		for (int i=0;i<archiveCar.size();i++) {
			if(archiveCar.get(i).getId().equals(id)) {
				car = archiveCar.get(i);
			}
		}
		return car;
	}

	@Override
	public boolean deleteCar(CarModel id) {
		return archiveCar.remove(id);

	}

	@Override
	public boolean updateAmount(Integer amount) {
		for (int i=0;i<archiveCar.size();i++) {
			if(archiveCar.get(i).getId().equals(amount)) {
				archiveCar.get(i).setAmount(amount);
				return true;
			}
		}
		return false;
	}
}
