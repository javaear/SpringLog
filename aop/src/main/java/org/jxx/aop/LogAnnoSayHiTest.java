package org.jxx.aop;

import javafx.scene.shape.Path;
import lombok.extern.slf4j.Slf4j;
import org.jxx.aop.annotation.EnableSpringLog;
import org.jxx.aop.annotation.SpringLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: javaear
 * @Version: 1.0
 */
@RestController
@Slf4j
public class LogAnnoSayHiTest {


    @RequestMapping(value = "/hi/a")
    @SpringLog
    public String hiAround(){
        System.out.println(" hello,---------springlog");
        return "hi=======hiAround======";
    }

    @RequestMapping(value = "/hi/a2")
    @SpringLog(opType = "around")
    public String hiAournd2(){
        System.out.println(" hiAournd2,---------around");
        return "hiAournd2=============";
    }

    @RequestMapping(value = "/hi/start")
    @SpringLog(opType = "start")
    public String hiStart(){
        System.out.println(" hiStart,---------hiStart");
        return "hiStart=============";
    }

    @RequestMapping(value = "/hi/end")
    @SpringLog(opType = "end")
    public String hiEnd(){
        System.out.println(" hiEnd,---------hiEnd");
        return "hiEnd=============";
    }

    /**
     * 无拦截
     * @return
     */
    @RequestMapping(value = "/hi/no")
    public String hiNo(){
        System.out.println(" nooooo,---------hiNo");
        return "hiNo=============";
    }
}
