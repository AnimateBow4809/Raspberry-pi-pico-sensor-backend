package animate.cn2test1.DAO;

import animate.cn2test1.entity.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataRepo repo;

    @Override
    public MyData persistData(MyData myData) {
        return repo.save(myData);
    }

    @Override
    public void removeData(MyData myData) {
        repo.delete(myData);
    }

    @Override
    public MyData getDataById(Long id) {
        Optional<MyData> data=repo.findById(id);
        return data.orElse(null);
    }

    @Override
    public MyData getRecentData(){ return repo.getRecentTemp();}

    @Override
    public List<MyData> getDataByTime(String lInstant, String hInstant) {
        return repo.findByTime(lInstant,hInstant);
    }

    @Override
    public List<MyData> getDataByMinAndMaxTemp(Float lowTemp, Float highTemp) {
        return repo.getDataByMinAndMaxTemp(lowTemp,highTemp);
    }
}
