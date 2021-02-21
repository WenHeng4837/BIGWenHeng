package com.yxy.service_userCenter.bean.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//给吴丽慧用的
@Data
@ApiModel(value="VoServiceUserto对象", description="吴丽慧用的")
public class VoServiceUserto {
    private static final long serialVersionUID=1L;
    @ApiModelProperty(value = "学号")
    @TableField("userId")
    private String userId;
  /*  @ApiModelProperty(value = "学校")
    @TableField("schoolName")
    private String schoolName;*/
}
