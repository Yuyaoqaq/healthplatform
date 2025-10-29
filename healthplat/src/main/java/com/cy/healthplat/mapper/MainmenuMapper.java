package com.cy.healthplat.mapper;

import com.cy.healthplat.pojo.Mainmenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 21701
* @description 针对表【mainmenu】的数据库操作Mapper
* @createDate 2025-10-24 14:52:36
* @Entity com.cy.healthplat.pojo.Mainmenu
*/
public interface MainmenuMapper extends BaseMapper<Mainmenu> {

    List<Mainmenu> getAll();

    List<Mainmenu> getAll0();
}




