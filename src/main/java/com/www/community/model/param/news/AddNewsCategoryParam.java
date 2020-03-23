package com.www.community.model.param.news;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 添加资讯分类
 */
@Data
@ApiModel
public class AddNewsCategoryParam {

    @ApiModelProperty(value = "id")
    private Integer categoryId;
    @ApiModelProperty(value = "分类名称", required = true)
    private String categoryName;
    @ApiModelProperty(value = "排序序号")
    private Integer sortId;
    @ApiModelProperty(value = "所属上级分类编号")
    private Integer parentId;
    @ApiModelProperty(value = "层级")
    private Integer level;
    @ApiModelProperty(value = "用户编号")
    private String userCode;
    @ApiModelProperty(value = "有效标志")
    private String yxBz;
    @ApiModelProperty(value = "分类编号")
    private String categoryCode;
}
