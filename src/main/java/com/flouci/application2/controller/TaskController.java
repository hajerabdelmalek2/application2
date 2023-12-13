package com.flouci.application2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flouci.application2.model.Task;
import com.flouci.application2.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired
	TaskService taskService;

	@PostMapping("/calculate")
	public ResponseEntity<String> calculateTask(@RequestBody Task task) {
		taskService.calculateTask(task);
		return ResponseEntity.ok("Task calculated successfully");
	}
}
