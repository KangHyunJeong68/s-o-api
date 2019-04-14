package kr.co.saramin.api.developer.service;

import kr.co.saramin.api.developer.domain.Developer;
import kr.co.saramin.api.developer.dto.LoginRequest;
import kr.co.saramin.api.developer.mapper.DeveloperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("kr.co.saramin.api.developer.service.DeveloperService")
public class DeveloperService {

    @Autowired DeveloperMapper developerMapper;

    public int insertDev(Developer dev) throws Exception {
        System.out.println("insert + " + dev.toString());
        return developerMapper.addDeveloper(dev);
    }

    public int updateDev(Developer dev) throws Exception {
        return developerMapper.modifyDeveloper(dev);
    }

    public int deleteDev(Integer idx) throws Exception {
        return developerMapper.deleteDeveloper(idx);
    }

    public Developer getDevData(Integer idx) throws Exception {
        return developerMapper.getDeveloperDataByIdx(idx);
    }

    public Developer getDevData(Developer dev) throws Exception {
        return developerMapper.getDeveloperDataByEmail(dev);
    }

    public Developer getDevCnt(String email) throws Exception {
        return developerMapper.getDeveloperCnt(email);
    }

    public Developer findUser(LoginRequest loginRequest) throws Exception {
        Developer loginUser = developerMapper.getDeveloperDataByEmail(loginRequest.user());
        if (loginUser == null) {
            throw new RuntimeException("아이디와 비밀번호를 확인해주세요.");
        }
        return loginUser;
    }

}
