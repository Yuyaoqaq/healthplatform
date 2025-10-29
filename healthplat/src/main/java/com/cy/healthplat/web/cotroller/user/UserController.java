package com.cy.healthplat.web.cotroller.user;


import com.cy.healthplat.common.exception.UserAddException;
import com.cy.healthplat.common.exception.UserDeleteException;
import com.cy.healthplat.common.exception.UserRoleChangeException;
import com.cy.healthplat.common.util.Result;
import com.cy.healthplat.common.util.ResultCode;
import com.cy.healthplat.common.util.UserConvertMapper;
import com.cy.healthplat.pojo.Easyuser;
import com.cy.healthplat.service.EasyuserService;
import com.cy.healthplat.web.dto.UserAdd_EditDTO;
import com.cy.healthplat.web.dto.UserQueryDTO;
import com.cy.healthplat.web.dto.UserRoleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j
public class UserController {
    @Autowired
    EasyuserService easyuserService;
    @Autowired
    UserConvertMapper userConvertMapper;

    @GetMapping("list")
    public Result<List<Easyuser>> userList(UserQueryDTO query) {
        try {

            List<Easyuser> resultList = easyuserService.queryUserList(query);
            //直接返回成功结果（即使列表为空，也应返回空列表而非null）
            Long total = easyuserService.queryTotal();
            return Result.success(resultList, total);
        } catch (Exception e) {
            log.error("查询用户列表失败", e); // 记录错误日志
            return Result.fail(ResultCode.DATA_NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public Result userAdd(@RequestBody UserAdd_EditDTO userAddEditDTO) {
        try {
            easyuserService.addUser(userAddEditDTO);
            return Result.success();
        } catch (UserAddException e) {
            return Result.fail(e.getCode(), e.getMsg());
        } catch (Exception e) {
            return Result.fail(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public Result<Easyuser> userEditbefore(@PathVariable("id") Integer id){
        Easyuser user = easyuserService.getById(id);
        if (user == null) {
            return Result.fail(ResultCode.DATA_NOT_FOUND);
        }
        return Result.success(user);
    }

    @PutMapping("/edit")
    public Result userEdit(@RequestBody UserAdd_EditDTO userAddEditDTO){
        Easyuser user = userConvertMapper.dtoToUser(userAddEditDTO);
        try {
            boolean res = easyuserService.updateById(user);
            if(res)return Result.success();
            return Result.fail(1004,"乐观锁---");
        }catch(Exception e){
            return Result.fail(1005,"数据库异常");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result userDelete(@PathVariable("id") Integer id){
        try {
            easyuserService.deleteUserById(id);
            return Result.success();
        }catch (UserDeleteException exception){
            return Result.fail(exception.getCode(),exception.getMsg());
        }catch (Exception e){
            return Result.fail(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/role")
    public Result userRoleupdate(@RequestBody UserRoleDTO userRoleDTO){
        Integer id = userRoleDTO.getId();
        String role = userRoleDTO.getRole();
        try{
            easyuserService.updateRole(role,id);
            return Result.success();
        }catch (UserRoleChangeException exception){
            return Result.fail(exception.getCode(),exception.getMsg());
        }catch (Exception e){
            return Result.fail(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }
}