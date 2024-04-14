package animate.cn2test1.DAO;

import animate.cn2test1.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

public interface DataRepo extends JpaRepository<MyData,Long> {

    @Query(value = "select * from DATA data where data.time >= " +
            "TO_DATE(:lInstant,'yyyy-MM-dd HH24:mi:ss') " +
            " and data.time <= TO_DATE(:hInstant,'yyyy-MM-dd HH24:mi:ss')"
            ,nativeQuery = true)
    public List<MyData> findByTime(@Param(value = "lInstant") String lInstant,
                                   @Param(value = "hInstant") String hInstant);


    @Query(value = "select * from DATA d where d.TEMP between ?1  and ?2",nativeQuery = true)
    public List<MyData> getDataByMinAndMaxTemp(Float lowTemp,Float highTemp);

    @Query(value = "select * from DATA d where d.TIME=(select MAX(n.TIME) from DATA n)",nativeQuery = true)
    public MyData getRecentTemp();
}
