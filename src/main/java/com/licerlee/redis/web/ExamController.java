package com.licerlee.redis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    /**
     * 抽题
     * @param userid
     * @param examId
     * @return
     */
    @RequestMapping(value = "/select/{userId}/{examId}", method = RequestMethod.GET)
    public String fetchExam(@PathVariable("userId") String userid, @PathVariable("examId") String examId){
//        return "haha";
        return examService.fetchAndPush2MQ(userid, examId);
    }

    /**
     * 打开试卷
     * @param userid
     * @param examId
     * @return
     */
    @GetMapping("/get")
    public String getPaperByUserAndExam(String userid, String examId){

        return "";
    }

}
