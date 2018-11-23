package com.jidouauto.log.controller;

import com.jidouauto.log.model.UserDomain;
import com.jidouauto.log.service.personal.PersonalService;
import com.jidouauto.log.service.user.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController("UserController")
@RequestMapping("/v1")
@Api(description = "user", tags = "user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    PersonalService personalService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(UserDomain user) {
        return userService.addUser(user);
    }
//
//    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
//    @ApiOperation(value = "获取所有用户数据", notes = "获取所有用户数据")
//    public Object findAllUser(
//            @ApiParam(required = true, name = "pageNum", value = "页码")
//            @RequestParam(value = "pageNum", required = true) int pageNum,
//            @ApiParam(required = true, name = "pageSize", value = "条数")
//            @RequestParam(value = "pageSize", required = true) int pageSize) {
//        return userService.findAllUser(pageNum, pageSize);
//    }
//
//    @RequestMapping(value = "/getAll2", method = RequestMethod.GET)
//    @ApiOperation(value = "获取所有用户数据", notes = "获取所有用户数据")
//    public Object getAllPerson(@ApiParam(required = true, name = "pageNum", value = "页码")
//                               @RequestParam(value = "pageNum", required = true) int pageNum,
//                               @ApiParam(required = true, name = "pageSize", value = "条数")
//                               @RequestParam(value = "pageSize", required = true) int pageSize) {
//        return personalService.getAll(pageNum, pageSize);
//    }
}
