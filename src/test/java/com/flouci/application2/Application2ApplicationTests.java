package com.flouci.application2;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import com.flouci.application2.model.Task;
import com.flouci.application2.service.TaskService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class Application2ApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	private TaskService taskService;

	@Mock
	private RabbitTemplate rabbitTemplate;

	@Test
	public void testCalculateTask() {
		Task task = new Task(4L, 400D, 40D);
		taskService.calculateTask(task);
		double expectedTotal = (task.getAmount() * task.getTva()) / 100;
		verify(rabbitTemplate).convertAndSend(eq("task-exchange"), eq("task-routing-key"), eq(expectedTotal));
	}
}
