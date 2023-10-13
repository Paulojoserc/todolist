package br.com.pjtec.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pjtec.todolist.user.UserModel;

public interface ITaskRepository extends JpaRepository <UserModel, UUID> {

	Object save(TaskModel taskModel);



}
