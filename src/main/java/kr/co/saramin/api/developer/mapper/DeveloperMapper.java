package kr.co.saramin.api.developer.mapper;

import kr.co.saramin.api.developer.domain.Developer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeveloperMapper {

    public int addDeveloper(Developer dev) throws Exception;

    public int modifyDeveloper(Developer dev) throws Exception;

    public int deleteDeveloper(Integer idx) throws Exception;

    public Developer getDeveloperDataByIdx(Integer idx) throws Exception;

    public Developer getDeveloperDataByEmail(Developer dev) throws Exception;

    public Developer getDeveloperCnt(String email) throws Exception;


}
