package com.cy.healthplat.service;


import com.cy.healthplat.pojo.Easyuser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.healthplat.web.dto.PieDTO;
import com.cy.healthplat.web.dto.UserAdd_EditDTO;
import com.cy.healthplat.web.dto.UserQueryDTO;

import java.util.List;

/**
* @author 21701
* @description 针对表【easyuser】的数据库操作Service
* @createDate 2025-10-24 14:52:18
*/
public interface EasyuserService extends IService<Easyuser> {

    List<Easyuser> queryUserList(UserQueryDTO query);

    Long queryTotal();

    void addUser(UserAdd_EditDTO userAddEditDTO);

    void deleteUserById(Integer id);

    void updateRole(String role,Integer id);

    List<PieDTO> rolePie();
}
