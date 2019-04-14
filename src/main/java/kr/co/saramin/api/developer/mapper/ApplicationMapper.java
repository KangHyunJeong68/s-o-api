package kr.co.saramin.api.developer.mapper;

import kr.co.saramin.api.developer.domain.Application;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    public int appInsert(Application app) throws Exception;

    public List<Application> appList(Integer dev_idx) throws Exception;

    public int appDelete(Integer idx) throws Exception;

}
