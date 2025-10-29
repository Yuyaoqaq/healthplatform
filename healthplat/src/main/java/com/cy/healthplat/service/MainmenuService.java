package com.cy.healthplat.service;

import com.cy.healthplat.pojo.Mainmenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 21701
* @description 针对表【mainmenu】的数据库操作Service
* @createDate 2025-10-24 14:52:36
*/
public interface MainmenuService extends IService<Mainmenu> {

    List<Mainmenu> getAll(String role);
}
