package animate.cn2test1.controller;

import animate.cn2test1.DAO.DataService;
import animate.cn2test1.entity.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
public class TempController {

    @Autowired
    private DataService dataService;

    @PostMapping("/api/temp/add")
    public MyData addData(@RequestBody MyData myData){
        return dataService.persistData(myData);
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/api/temp/new")
    public MyData getNewData(){
        return dataService.getRecentData();
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/api/temp/between/{temp1}/and/{temp2}")
    public List<MyData> getBetweenTemp(@PathVariable Float temp1, @PathVariable Float temp2){
        return dataService.getDataByMinAndMaxTemp(temp1,temp2);
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/api/temp/tbetween/{time1}/and/{time2}")
    public List<MyData> getBetweenTime(@PathVariable String time1,
                                       @PathVariable String time2){
        System.out.println(time2);
        System.out.println(time1);
        return dataService.getDataByTime(time1,time2);
    }

}
