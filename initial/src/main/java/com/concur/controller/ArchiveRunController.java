package com.concur.controller;

import com.concur.model.ArchiveRun;
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

    // @Autowired
    // private ArchiveRunDao archiveRunDao;

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
        // ArchiveRun run = new ArchiveRun();
        System.out.println("in archive run function");

        List<ArchiveRun> archiveRuns
                = new ArrayList<>(archiveRunService.findArchiveRuns());

        return archiveRuns.get(0);
//        return run;
    }
}
