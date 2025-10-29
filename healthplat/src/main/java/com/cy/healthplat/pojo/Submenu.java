package com.cy.healthplat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName submenu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submenu {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String path;

    /**
     * 
     */
    private Integer mid;

}