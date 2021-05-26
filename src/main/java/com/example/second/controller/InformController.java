package com.example.second.controller;

import com.example.second.entity.Inform;
import com.example.second.service.InformService;
import com.example.second.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inform")
@CrossOrigin(allowCredentials = "true")
public class InformController {

    @Autowired
    private InformService informService;

    @Autowired
    MenuService menuService;

    /**
     *
     */
    @GetMapping("/findAllInforms")
    public List<Inform> findAllInforms() {
        return this.informService.findAllInforms();
    }

    /**
     *
     */
    @PostMapping("/addInform")
    public void addInform(@RequestBody Inform inform) {
        this.informService.addInform(inform);
    }

    /**
     *
     */
    @PostMapping("/deleteInform")
    public void deleteInformById(@RequestParam Long uid) {
        this.informService.deleteInformById(uid);
    }

    /**
     *
     */
    @PostMapping("/updateInform")
    public void updateInform(@RequestBody Inform inform) {
        this.informService.updateInform(inform);
    }

    /**
     *
     */
    @GetMapping("/findInformByName")
    public List<Inform> findInformByName(@RequestParam String name) {
        return this.informService.findInformByName(name);
    }

    /**
     *
     */
    @PostMapping("/deleteInformsByNos")
    public Integer deleteInformsByIds(Integer[] uids) {
        return this.informService.deleteInformsByIds(uids);
    }
}
