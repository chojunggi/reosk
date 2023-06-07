package com.kiosk.reosk.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiosk.reosk.entity.Menu;
import com.kiosk.reosk.service.MenuService;

@RestController
@RequestMapping("/reosk")

public class MenuController {

	@Autowired
    MenuService menuservice;
    
    
    @GetMapping("/menuList")
    
    public List<Menu> getMenus(){
    	List<Menu> menus = menuservice.getAllMenus(); // 예시: MenuService를 통해 메뉴 데이터 조회
        return menus;
    }
    
    @PostMapping("/menucr")
    public String addMenuData(@RequestBody List<Menu> menuData) {
      // 메뉴 데이터 처리 로직 구현
      // menuData를 받아서 서버에서 처리할 작업을 수행합니다.
    	menuservice.saveMenus(menuData);
    	System.out.println("transdata" + menuData.toString());
    	return "redirect:/reosk/menutest";
    } 
//    @PostMapping("/menucr")
//    public void addMenuData(@RequestBody List<MenuDTO> menudto) {
//        // 메뉴 데이터 처리 로직 구현
//        // menuData를 받아서 서버에서 처리할 작업을 수행합니다.
//    	System.out.println("************");
//      	System.out.println("transdata" + menudto);
//      }

}
