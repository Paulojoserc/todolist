package br.com.pjtec.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private ITaskRepository taskRepository;
	
	@PostMapping("/")
	public Object create(@RequestBody TaskModel taskModel) {
		System.out.println("Chegou no controlller");
		var task = this.taskRepository.save(taskModel);
		return task;
	}
}
