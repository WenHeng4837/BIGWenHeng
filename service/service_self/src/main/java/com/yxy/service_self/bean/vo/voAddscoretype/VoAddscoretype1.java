package com.yxy.service_self.bean.vo.voAddscoretype;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data//管理员用的
@ApiModel(value="VoAddscoretype1", description="自测加分大类初始化辅助类")
public class VoAddscoretype1 {
    /*
    @ApiModelProperty(value = "自测加分大类Id")
    private String addscoretypeId;*/
   /*
    @ApiModelProperty(value = "学号Id")
    private String userId;*/

    @ApiModelProperty(value = "学校名字")
    @TableField("schoolName")
    private String schoolName;

    @ApiModelProperty(value = "院系名字")
    @TableField("department")
    private String department;

   /* @ApiModelProperty(value = "专业名字")
    @TableField(" majorName")
    private String majorName;
*/
    @ApiModelProperty(value = "自测分数类型")
    @TableField("selfTestScoreType")
    private String selfTestScoreType;

    @ApiModelProperty(value = "分数比例")
    private Float proportion;

    @ApiModelProperty(value = "年份",example = "2019")
    private String  year;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    //这里数据库是year,但是在mybatis官网看到一组数据，原来是mybatis不支持YEAR类型的。
    //把实体类Date year;改成 Integer year;
    //数据库仍然是year YEAR字段类型。
    @ApiModelProperty(value = "自测截止时间",example = "2019-01-01 ")
    @TableField("studentDeadline")
    private String studentDeadline;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "自测审核截止时间",example = "2019-01-01 ")
    @TableField(" managerDeadline")
    private String managerDeadline;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

}

