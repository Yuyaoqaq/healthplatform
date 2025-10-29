package com.cy.healthplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.healthplat.common.exception.UserAddException;
import com.cy.healthplat.common.exception.UserDeleteException;
import com.cy.healthplat.common.exception.UserRoleChangeException;
import com.cy.healthplat.common.util.UserConvertMapper;
import com.cy.healthplat.pojo.Easyuser;
import com.cy.healthplat.service.EasyuserService;
import com.cy.healthplat.mapper.EasyuserMapper;
import com.cy.healthplat.web.dto.UserAdd_EditDTO;
import com.cy.healthplat.web.dto.UserQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 21701
* @description 针对表【easyuser】的数据库操作Service实现
* @createDate 2025-10-24 14:52:18
*/
@Service
public class EasyuserServiceImpl extends ServiceImpl<EasyuserMapper, Easyuser>
    implements EasyuserService{
    @Autowired
    EasyuserMapper easyuserMapper;
    @Autowired
    UserConvertMapper userConvertMapper;

    long total;

    @Override
    public List<Easyuser> queryUserList(UserQueryDTO query) {
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        String key = query.getSearchType();
        String value = query.getSearchValue();
        Page<Easyuser> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Easyuser> wrapper = new QueryWrapper<>();
        if (key != null && !key.trim().isEmpty()) { // 去除空格后判断非空
            wrapper.like(key,value); // 用 Lambda 表达式指定实体类属性
        }
        page = easyuserMapper.selectPage(page, wrapper);
        total=page.getTotal();
        return page.getRecords();
    }

    @Override
    public Long queryTotal() {
        return total;
    }

    @Override
    public void addUser(UserAdd_EditDTO userAddEditDTO) {
        if (userAddEditDTO.getUsername() == null || userAddEditDTO.getUsername().trim().isEmpty()) {
            throw new UserAddException(1001, "用户名不能为空");
        }
        QueryWrapper<Easyuser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userAddEditDTO.getUsername());
        Easyuser easyuser = easyuserMapper.selectOne(wrapper);
        if (easyuser!=null) {
            throw new UserAddException(1002, "用户名已存在");
        }
        Easyuser user = userConvertMapper.dtoToUser(userAddEditDTO);
        try {
            easyuserMapper.insert(user);
        } catch (Exception e) {
            // 捕获数据库异常，包装成自定义业务异常抛出
            throw new UserAddException(1003, "数据库添加用户失败", e);
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        try{
        boolean res = easyuserMapper.deleteUserById(id);
        if(!res){
            throw new UserDeleteException(1006,"数据库删除用户失败");
        }}catch (Exception e){
            throw new UserDeleteException(1007,e.getMessage(),e.getCause());
        }
    }

    @Override
    public void updateRole(String role,Integer id) {
        try{
        boolean res = easyuserMapper.updateRole(role,id);
        if(!res){
            throw new UserRoleChangeException(1008,"数据库分配角色失败");
        }}catch (Exception e){
            throw new UserDeleteException(1009,e.getMessage(),e.getCause());
        }
    }
}




