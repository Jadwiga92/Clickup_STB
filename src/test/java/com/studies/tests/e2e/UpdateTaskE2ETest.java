package com.studies.tests.e2e;

import com.studies.tests.dto.request.CreateTaskRequestDto;
import com.studies.tests.dto.request.UpdateTaskRequestDto;
import com.studies.tests.dto.response.CreateTaskResponseDto;
import com.studies.tests.requests.list.CreateListRequest;
import com.studies.tests.requests.space.CreateSpaceRequest;
import com.studies.tests.requests.space.DeleteSpaceRequest;
import com.studies.tests.requests.task.CreateTaskRequest;
import com.studies.tests.requests.task.UpdateTaskRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateTaskE2ETest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateTaskE2ETest.class);
    String spaceId;
    String listId;
    String taskId;

    @Test
    public void updateTaskE2ETest() {
        createSpaceStep();
        LOGGER.info("space created with id: {}", spaceId);

        createFolderlessList();
        LOGGER.info("list created with id: {}", listId);

        taskId = createTaskStep();
        LOGGER.info("task created with id: {}", taskId);

        updateTaskStep();

        closeTaskStep();

        deleteSpaceSteo();
    }

    public String createSpaceStep() {
        JSONObject space = new JSONObject();
        space.put("name", "nowy space");

        Response response = CreateSpaceRequest.createSpace(space);
        JsonPath json = response.jsonPath();
        spaceId = json.getString("id");

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(json.getString("name")).isEqualTo("nowy space");
        return spaceId;
    }

    public String createFolderlessList() {
        JSONObject list = new JSONObject();
        list.put("name", "Zadania do zrobienia");

        Response response = CreateListRequest.createFolderlessList(list, spaceId);
        JsonPath json = response.jsonPath();
        listId = json.getString("id");

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(json.getString("name")).isEqualTo("Zadania do zrobienia");
        return listId;

    }

    public String createTaskStep() {
//        JSONObject task = new JSONObject();
//        task.put("name", "Task nr 1");
//        task.put("description", "Testowy opis taska");
//        task.put("assigneesv", "[]");
//        task.put("status", "to do");
//        task.put("priority", "3");
        CreateTaskRequestDto taskDto = new CreateTaskRequestDto();
        taskDto.setName("Zadanie");
        taskDto.setDescription("Testowy opis taska");
        taskDto.setAssigneesv("[]");
        taskDto.setStatus("to do");
        taskDto.setPriority("3");

        CreateTaskResponseDto response = CreateTaskRequest.createTaskRequestDto(taskDto, listId);
        LOGGER.info("Create task response obj: {}", response);

        Assertions.assertThat(response.getName()).isEqualTo("Zadanie");
        Assertions.assertThat(response.getDescription()).isEqualTo("Testowy opis taska");
        Assertions.assertThat(response.getCreator().getUsername()).isEqualTo("Jadwiga Mazurek");

//        JsonPath json = response.jsonPath();
//        taskId = json.getString("id");
//
//        Assertions.assertThat(response.statusCode()).isEqualTo(200);
//        Assertions.assertThat(json.getString("name")).isEqualTo("Zadanie");
//        Assertions.assertThat(json.getString("description")).isEqualTo("Testowy opis taska");
//
//        return taskId;
        return response.getId();
    }

    private void updateTaskStep() {
        UpdateTaskRequestDto taskDto = new UpdateTaskRequestDto();
        taskDto.setName("Updated Zadanie");
        taskDto.setDescription("Updated Testowy opis taska");
        taskDto.setAssigneesv("[]");
        taskDto.setStatus("to do");
        taskDto.setPriority("3");


        Response response = UpdateTaskRequest.updateTaskDto(taskDto, taskId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        JsonPath json = response.jsonPath();
        Assertions.assertThat(json.getString("name")).isEqualTo("Updated Zadanie");
        Assertions.assertThat(json.getString("description")).isEqualTo("Updated Testowy opis taska");
    }

    private void closeTaskStep() {
        JSONObject closeTask = new JSONObject();
        closeTask.put("status", "complete");

        Response response = UpdateTaskRequest.updateTask(closeTask, taskId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath json = response.jsonPath();
        Assertions.assertThat(json.getString("status.status")).isEqualTo("complete");

    }

    private void deleteSpaceSteo() {
        Response response = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }
}
