package mapper;

import model.Earning;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EarningMapper {

    int insert(@Param("pojo") Earning pojo);

    int insertList(@Param("pojos") List< Earning> pojo);

    List<Earning> select(@Param("pojo") Earning pojo);

    int update(@Param("pojo") Earning pojo);

}
