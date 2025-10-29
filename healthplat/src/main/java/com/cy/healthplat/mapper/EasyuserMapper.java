package com.cy.healthplat.mapper;

import com.cy.healthplat.pojo.Easyuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


/**
* @author 21701
* @description 针对表【easyuser】的数据库操作Mapper
* @createDate 2025-10-24 14:52:18
* @Entity com.cy.healthplat.pojo.Easyuser
*/

public interface EasyuserMapper extends BaseMapper<Easyuser> {

    boolean deleteUserById(Integer id);

    boolean updateRole(@Param("role")String role,@Param("id") Integer id);
}




