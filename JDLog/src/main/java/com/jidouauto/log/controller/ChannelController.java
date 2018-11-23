package com.jidouauto.log.controller;

import com.jidouauto.log.service.channel.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @ResponseBody
    @GetMapping("/getAll")
    public Object getAll(){
        return channelService.getChannels();
    }

}
