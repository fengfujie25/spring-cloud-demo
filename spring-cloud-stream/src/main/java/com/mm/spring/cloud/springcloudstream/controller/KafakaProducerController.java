package com.mm.spring.cloud.springcloudstream.controller;

import com.mm.spring.cloud.springcloudstream.service.KafakaSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: fujie.feng
 * @DateT: 2019-11-24
 */
@RestController
public class KafakaProducerController {

    @Autowired
    private KafakaSendService kafakaSendService;

    @RequestMapping("/send/{msg}")
    public void send(@PathVariable String msg) {
        kafakaSendService.sendMsg(msg);
    }
}
