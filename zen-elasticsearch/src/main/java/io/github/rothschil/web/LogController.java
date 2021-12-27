package io.github.rothschil.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController {

    private LogIndexManager logIndexManager;

    @Autowired
    public void setLogIndexManager(LogIndexManager logIndexManager) {
        this.logIndexManager = logIndexManager;
    }

    @GetMapping("/get")
    public List<AccLog> query(){
        return logIndexManager.query();
    }
}
