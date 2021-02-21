package com.yxy.service_userCenter.bean.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//给吴丽慧用的
@Data
@ApiModel(value="VoServiceUser2对象", description="吴丽慧用的")
public class VoServiceUser2 {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "班级")
    @TableField("className")
    private String className;

    @ApiModelProperty(value = "院系名字")
    @TableField("department")
    private String department;

    @ApiModelProperty(value = "学校")
    @TableField("schoolName")
    private String schoolName;

    @ApiModelProperty(value = "专业")
    @TableField("majorName")
    private String majorName;



}

