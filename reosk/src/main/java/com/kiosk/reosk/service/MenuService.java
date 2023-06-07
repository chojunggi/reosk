package com.kiosk.reosk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiosk.reosk.entity.Menu;
import com.kiosk.reosk.repository.MenuRepository;

@Service
public class MenuService {
	private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }
    
    public void saveMenus(List<Menu> menus) {
        menuRepository.saveAll(menus);
    }
}
