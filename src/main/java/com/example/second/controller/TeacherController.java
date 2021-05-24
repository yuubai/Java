package com.example.second.controller;


import com.example.second.entity.Response;
import com.example.second.entity.Teacher;
import com.example.second.service.MenuService;
import com.example.second.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(allowCredentials = "true")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    MenuService menuService;

    /**
     * 查询所有教师
     */
    @GetMapping("/findAllTeachers")
    public List<Teacher> findAllTeachers() {
        return this.teacherService.findAllTeachers();
    }

    /**
     * 增加教师
     */
    @PostMapping("/addTeacher")
    //public Response addTeacher(@RequestBody Teacher teacher){
//        if(teacher.getName().length()<2 || teacher.getName().length()>15){
//            return new Response(false,"来自后端校验：姓名在2-15个字符之间");
//        }
//        if(teacher.getAge()<25 || teacher.getAge()>65){
//            System.out.println("教师年龄应在25--65岁之间");
//            return new Response(false,"来自后端校验：教师年龄应在25--65岁之间");
//        }
//        if(teacher.getYear()>2021){
//            System.out.println("年份不超过今年");
//            return new Response(false,"来自后端校验：年份不超过今年");
//        }
//        if(teacher.getHeight()>200){
//            System.out.println("教师身高不超过200 cm");
//            return new Response(false,"来自后端校验：教师身高不超过200 cm");
//        }
//        if(teacher.getWeight()>100){
//            System.out.println("教师体重不超过100kg");
//            return new Response(false,"来自后端校验：教师体重不超过100kg");
//        }
//        this.teacherService.addTeacher(teacher);
//        return new Response(true,"添加教师成功（来自后端校验）");
//    }
    public void addTeacher(@RequestBody Teacher teacher) {
        this.teacherService.addTeacher(teacher);
    }

    /**
     * 根据教师id删除教师
     */
    @PostMapping("/deleteTeacher")
    public void deleteTeacherById(@RequestParam Long uid) {
        this.teacherService.deleteTeacherById(uid);
    }

    /**
     * 编辑教师
     */
    @PostMapping("/updateTeacher")
    public void updateTeacher(@RequestBody Teacher teacher) {
        this.teacherService.updateTeacher(teacher);
    }

    /**
     * 根据教师姓名查找教师
     */
    @GetMapping("/findTeacherByName")
    public List<Teacher> findTeacherByName(@RequestParam String name) {
        return this.teacherService.findTeacherByName(name);
    }

    /**
     * 批量删除教师
     */
    @PostMapping("/deleteTeachersByIds")
    public Integer deleteTeachersByIds(Integer[] ids) {
        return this.teacherService.deleteTeachersByIds(ids);
    }
}
