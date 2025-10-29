package com.cy.healthplat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 
 * @TableName mainmenu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mainmenu {
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

    private List<Submenu> sList;
}