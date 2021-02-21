package com.yxy.service_userCenter.provider.Impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxy.service_userCenter.bean.ServiceUser;
import com.yxy.service_userCenter.bean.vo.*;
import com.yxy.service_userCenter.mapper.ServiceUserMapper;
import com.yxy.service_userCenter.provider.ServiceproviderService;
import com.yxy.service_userCenter.service.ServiceUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = ServiceproviderService.class, protocol = {"userCenterhessian"})
public class ServiceproviderServiceImpl  extends ServiceImpl<ServiceUserMapper, ServiceUser> implements ServiceproviderService {
    @Autowired
    ServiceUserService ServiceUserService;
    @Override//吴丽慧用的
    public List<VoServiceUser1> selectUser1(VoServiceUser2 VoServiceUser2) {
        QueryWrapper<ServiceUser> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("schoolName", VoServiceUser2.getSchoolName());
        map.put("majorName", VoServiceUser2.getMajorName());
        map.put("className", VoServiceUser2.getClassName());
        map.put("department",VoServiceUser2.getDepartment());
        queryWrapper.allEq(map);
        queryWrapper.select("userId","className","majorName","department","schoolName","name");
        List<ServiceUser>ServiceUser=baseMapper.selectList(queryWrapper);
        List<VoServiceUser1> VoServiceUser1=new ArrayList<>();
        VoServiceUser1 voServiceUser3=new VoServiceUser1();
        for(int i=0;i<ServiceUser.size();i++){
            BeanUtils.copyProperties(ServiceUser.get(i),voServiceUser3);
            VoServiceUser1.add(voServiceUser3);
        }
        return  VoServiceUser1;
    }

    @Override//吴丽慧用，管理员
    public List<VoServiceUser1> selectUser2(VoServiceUser5 VoServiceUser5) {
        QueryWrapper<ServiceUser> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("schoolName", VoServiceUser5.getSchoolName());
       // map.put("majorName", VoServiceUser3.getMajorName());
        map.put("department",VoServiceUser5.getDepartment());
        queryWrapper.allEq(map);
        queryWrapper.select("userId","className","majorName","department","schoolName","name");
        List<ServiceUser>ServiceUser=baseMapper.selectList(queryWrapper);
        List<VoServiceUser1> VoServiceUser1=new ArrayList<>();
        VoServiceUser1 voServiceUser5=new VoServiceUser1();
        for(int i=0;i<ServiceUser.size();i++){
            BeanUtils.copyProperties(ServiceUser.get(i),voServiceUser5);
            VoServiceUser1.add(voServiceUser5);
        }
        return  VoServiceUser1;
    }

    @Override
    public List<VoServiceUserto> selectUser3(VoServiceUser4 VoServiceUser4) {
        QueryWrapper<ServiceUser> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("schoolName", VoServiceUser4.getSchoolName());
        map.put("className",VoServiceUser4.getClassName());
        map.put("department",VoServiceUser4.getDepartment());
        queryWrapper.allEq(map);
        queryWrapper.select("userId");
        List<ServiceUser>ServiceUser=baseMapper.selectList(queryWrapper);
        List<VoServiceUserto> VoServiceUserto=new ArrayList<>();
        VoServiceUserto VoServiceUserto1=new VoServiceUserto();
        for(int i=0;i<ServiceUser.size();i++){
            BeanUtils.copyProperties(ServiceUser.get(i),VoServiceUserto1);
            VoServiceUserto.add(VoServiceUserto1);
        }
        return  VoServiceUserto;
    }

    @Override
    public List<VoServiceUserto> selectUser4(VoServiceUser3 VoServiceUser3) {
        QueryWrapper<ServiceUser> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("schoolName", VoServiceUser3.getSchoolName());
        map.put("majorName",VoServiceUser3.getMajorName());
        map.put("department",VoServiceUser3.getDepartment());
        queryWrapper.allEq(map);
        queryWrapper.select("userId");
        List<ServiceUser>ServiceUser=baseMapper.selectList(queryWrapper);
        List<VoServiceUserto> VoServiceUserto=new ArrayList<>();
        VoServiceUserto VoServiceUserto1=new VoServiceUserto();
        for(int i=0;i<ServiceUser.size();i++){
            BeanUtils.copyProperties(ServiceUser.get(i),VoServiceUserto1);
            VoServiceUserto.add(VoServiceUserto1);
        }
        return  VoServiceUserto;

    }


}
