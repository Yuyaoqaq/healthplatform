package com.cy.healthplat.web.cotroller;

import com.cy.healthplat.common.util.Result;
import com.cy.healthplat.common.util.ResultCode;
import com.cy.healthplat.pojo.Mainmenu;
import com.cy.healthplat.service.MainmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MainmenuService mainmenuService;

    @PostMapping("/menu")
    public Result menuLists(@RequestBody String role){
        System.out.println(role);
        List<Mainmenu> mainmenu= mainmenuService.getAll(role);
        System.out.println(mainmenu);
        if(mainmenu!=null)
        return Result.success(mainmenu);
        return Result.fail(ResultCode.DATA_NOT_FOUND);
    }
}
