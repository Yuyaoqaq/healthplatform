package com.cy.healthplat.web.cotroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cy.healthplat.common.util.Result;
import com.cy.healthplat.pojo.Easyuser;
import com.cy.healthplat.service.EasyuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    EasyuserService easyuserService;

    @PostMapping("/login")
    public Result<Object> login(@RequestBody Easyuser data){
        Easyuser user = easyuserService.getOne(
                new QueryWrapper<Easyuser>()
                        .eq("username", data.getUsername())
                        .eq("password",data.getPassword())
        );
        if(user!=null){
        return Result.success(user);
        }else{
            return Result.fail(602,"用户不存在");
        }
    }

}
