package com.cy.healthplat.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAdd_EditDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
