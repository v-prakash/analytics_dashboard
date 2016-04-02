package com.concur.controller;

import com.concur.model.ArchiveRun;
import com.concur.model.EntityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.concur.service.ArchiveRunService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArchiveRunController {

    @Autowired
    private ArchiveRunService archiveRunService;

    public ArchiveRunController() {
        System.out.println("in archive run controller constructor");
    }

    @RequestMapping("/blah/")
    public String indexNew() {
        return "Greetings from ArchiveRun Controller!";
    }

    @RequestMapping("/run.json")
    public
    @ResponseBody
    ArchiveRun showArchiveRun() {
        System.out.println("in archive run function");

        List<ArchiveRun> archiveRuns
                = new ArrayList<>(archiveRunService.findArchiveRuns());

        return archiveRuns.get(0);
    }

    @RequestMapping("/new_run.json")
    public
    @ResponseBody
    ArchiveRun showNewArchiveRun() {
        System.out.println("in new archive run function");

        List<ArchiveRun> archiveRuns
                = new ArrayList<>(archiveRunService.findArchiveRun("phos_gov12"));

        return archiveRuns.get(0);
    }
}
