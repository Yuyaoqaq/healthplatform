package com.cy.healthplat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.healthplat.pojo.Mainmenu;
import com.cy.healthplat.service.MainmenuService;
import com.cy.healthplat.mapper.MainmenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @author 21701
* @description 针对表【mainmenu】的数据库操作Service实现
* @createDate 2025-10-24 14:52:36
*/
@Service
public class MainmenuServiceImpl extends ServiceImpl<MainmenuMapper, Mainmenu>
    implements MainmenuService{
    @Autowired
    MainmenuMapper mainmenuMapper;

    @Override
    public List<Mainmenu> getAll(String role) {
        if(role.equals("{\"role\":\"\\\"超级管理员\\\"\"}")) {
            return mainmenuMapper.getAll0();
        }else{
            return mainmenuMapper.getAll();
        }
    }
}




