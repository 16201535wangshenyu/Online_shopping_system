package com.example.mallmaster;

import com.example.mallmaster.dao.ClassificationDao;
import com.example.mallmaster.dao.UserDao;
import com.example.mallmaster.entity.Classification;
import com.example.mallmaster.service.AdminUserService;
import com.example.mallmaster.service.UserService;
import com.example.mallmaster.web.admin.AdminUserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.DispatcherServlet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallMasterApplicationTests {
    @Autowired
    UserDao userDao;
    @Autowired
    ClassificationDao classificationDao;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserController adminUserController;



    @Test
    public void contextLoads() {
        Pageable pageable = new PageRequest(0, 15);
        System.out.println("sdsfsdfsdfdsssss"+userService.findAll(pageable).getTotalElements());
        /*System.out.println(classificationDao.findByType(1,pageable));*/
    }

    @Test
    public void validController() throws Exception {
        MockMvc mockMvc = standaloneSetup(adminUserController).build();
        mockMvc.perform(get("/admin/user/list.do?pageindex=0")).andReturn();

      /*  DispatcherServlet dispatcherServlet=mockMvc.getDispatcherServlet();
        System.out.println(dispatcherServlet.getContextAttribute());*/
    }

}
