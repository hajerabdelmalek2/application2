package com.flouci.application2.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.flouci.application2.model.Task;

@Service
public class TaskService {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Cacheable(value = "taskCache", key = "#task.id")
	public void calculateTask(Task task) {
		double total = (task.getAmount() * task.getTva()) / 100;
		rabbitTemplate.convertAndSend("task-exchange", "task-routing-key", total);
	}

}
