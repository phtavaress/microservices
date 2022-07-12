package com.dev.hrworker.controllers;

import com.dev.hrworker.entities.Worker;
import com.dev.hrworker.repositories.WorkerRepository;
import com.dev.hrworker.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private Environment environment;

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = workerService.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = " + environment.getProperty("local.server.port"));
        Worker worker = workerService.findById(id);
        return ResponseEntity.ok(worker);
    }

}
