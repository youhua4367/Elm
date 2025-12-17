package com.example.elm_m.Controller.Admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admin/employee")
@Tag(name = "员工登录", description = "员工登录相关接口")
public class EmployeeController {
    
}
