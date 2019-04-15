package kr.co.saramin.api.developer.service;

import kr.co.saramin.api.developer.domain.Application;
import kr.co.saramin.api.developer.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("kr.co.saramin.api.developer.service.ApplicationService")
public class ApplicationService {
    @Autowired private ApplicationMapper mapper;

    public int insertApplication(Application app) throws Exception {
        return mapper.appInsert(app);
    }

    public List<Application> selectApplicationList(Integer dev_idx) throws Exception {
        System.out.println("selectApplicationList --- " + dev_idx);
        return mapper.appList(dev_idx);
    }

    public int deleteApplication(Integer idx) throws Exception {
        return mapper.appDelete(idx);
    }

    public Application getAppData(Integer idx) throws Exception {
        return mapper.getAppData(idx);
    }
}
