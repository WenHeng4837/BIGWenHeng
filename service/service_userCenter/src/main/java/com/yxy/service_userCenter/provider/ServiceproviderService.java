package com.yxy.service_userCenter.provider;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxy.service_userCenter.bean.ServiceUser;
import com.yxy.service_userCenter.bean.vo.*;

import java.util.List;

public interface ServiceproviderService  {
    public List<VoServiceUser1> selectUser1(VoServiceUser2 VoServiceUser2);//给吴丽慧用的
    public List<VoServiceUser1> selectUser2(VoServiceUser5 VoServiceUser5);//给吴丽慧用的，给管理员用
    public List<VoServiceUserto> selectUser3(VoServiceUser4 VoServiceUser4);//给吴丽慧用的，给班干用
    public List<VoServiceUserto> selectUser4(VoServiceUser3 VoServiceUser3);//给吴丽慧用的，给管理员用
}
