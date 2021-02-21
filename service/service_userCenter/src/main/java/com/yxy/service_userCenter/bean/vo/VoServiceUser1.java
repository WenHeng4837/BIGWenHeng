package com.yxy.service_userCenter.bean.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
//给吴丽慧用的
@Data
@ApiModel(value="VoServiceUser1对象", description="吴丽慧用的")
public class VoServiceUser1 {
    private static final long serialVersionUID=1L;
    @ApiModelProperty(value = "学号")
    @TableField("userId")
    private String userId;

    @ApiModelProperty(value = "名字")
    @TableField("name")
    private String name;

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
