package com.cy.healthplat.common.util;

import com.cy.healthplat.pojo.Easyuser;
import com.cy.healthplat.web.dto.UserAdd_EditDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserConvertMapper {
    // 基础映射（属性名相同自动拷贝）
    // 显式指定每个字段的映射关系（即使名称相同）
    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    Easyuser dtoToUser(UserAdd_EditDTO dto);

    // 复杂场景：属性名不同时指定映射关系（如 DTO 的 userName → 实体的 name）
    // @Mapping(source = "userName", target = "name")
    // @Mapping(source = "userAge", target = "age")
    // User dtoToUserWithMapping(UserAdd_EditDTO dto);
}
