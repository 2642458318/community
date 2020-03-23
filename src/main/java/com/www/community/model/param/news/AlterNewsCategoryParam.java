package com.www.community.model.param.news;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * 修改新闻分类 参数类
 *
 * @author sunyuan
 * update by fx
 *
 */
@Data
public class AlterNewsCategoryParam {

    @ApiModelProperty(value = "分类ID",required = true)
    private Integer categoryId;

    @ApiModelProperty(value = "分类名称")
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


