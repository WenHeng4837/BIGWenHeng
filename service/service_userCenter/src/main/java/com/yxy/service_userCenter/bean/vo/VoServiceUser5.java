package com.yxy.service_userCenter.bean.vo;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//给吴丽慧用的
@Data//管理员查询专业自测模块时的辅助类（远程调用）
@ApiModel(value="VoServiceUser5对象", description="吴丽慧用的")
public class VoServiceUser5 {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "院系名字")
    @TableField("department")
    private String department;

    @ApiModelProperty(value = "学校")
    @TableField("schoolName")
    private String schoolName;

   /* @ApiModelProperty(value = "专业")
    @TableField("majorName")
    private String majorName;*/
}
