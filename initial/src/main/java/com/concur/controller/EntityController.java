package com.concur.controller;

import com.concur.model.ArchiveRun;
import com.concur.model.EntityInfo;
import com.concur.service.ArchiveRunService;
import com.concur.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EntityController {

    @Autowired
    private EntityService entityService;

    public EntityController() {
    }

    @RequestMapping("/dashboard/entity.json")
    public
    @ResponseBody
    EntityInfo showEntityInfo(@RequestParam(value="entityCode") String entityCode) {
        if (entityCode == null)
        System.out.println("entity code="+entityCode);
        return entityService.getEntityInfo(entityCode);
    }
}
