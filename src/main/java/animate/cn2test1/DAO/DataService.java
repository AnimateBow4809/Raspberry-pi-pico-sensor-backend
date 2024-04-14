package animate.cn2test1.DAO;

import animate.cn2test1.entity.MyData;

import java.time.Instant;
import java.util.List;

public interface DataService {

    public MyData persistData(MyData myData);

    public void removeData(MyData myData);

    public MyData getDataById(Long id);

    MyData getRecentData();

    public List<MyData> getDataByTime(String lInstant, String hInstant);

    public List<MyData> getDataByMinAndMaxTemp(Float lowTemp,Float highTemp);
}
