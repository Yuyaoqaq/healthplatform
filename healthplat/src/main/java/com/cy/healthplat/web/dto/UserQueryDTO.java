package com.cy.healthplat.web.dto;

// 导入正确的包（注意不是自定义的）
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryDTO {
    private String searchType;
    private String searchValue;
    @NotNull(message = "页码不能为空") // 参数校验：页码必传
    @Min(value = 1, message = "页码不能小于1") // 参数校验：页码至少为1
    private Integer pageNum;
    @NotNull(message = "页大小不能为空") // 参数校验：页大小必传
    @Min(value = 1, message = "页大小不能小于1") // 参数校验：页大小至少为1
    private Integer pageSize;
}
