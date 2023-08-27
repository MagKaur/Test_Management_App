package Test_Management_App.Controller;

import Test_Management_App.Model.*;
import Test_Management_App.Payloads.ApplicationCreatePayload;
import Test_Management_App.Payloads.ApplicationUpdatePayload;
import Test_Management_App.Payloads.TestTaskCreatePayload;
import Test_Management_App.Payloads.TestTaskUpdatePayload;
import Test_Management_App.Repository.TestTaskRepository;
import Test_Management_App.Service.TestTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/testTask")
public class TestTaskController {

    private TestTaskService testTaskService;
    private TestTaskRepository testTaskRepository;

    @Autowired

    public TestTaskController(TestTaskService testTaskService, TestTaskRepository testTaskRepository) {
        this.testTaskService = testTaskService;
        this.testTaskRepository = testTaskRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTestTask(@RequestBody TestTaskCreatePayload testTaskCreatePayload) {
        TestTask createdTestTask = testTaskService.createTestTask(testTaskCreatePayload);
        return ResponseEntity.ok("Test Task created");
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateTestTask(
            @PathVariable("id") int idTestTask,
            @RequestBody TestTaskUpdatePayload partialUpdate) {

        TestTask updatedTestTask = testTaskService.partialUpdateTestTask(idTestTask, partialUpdate);
        return ResponseEntity.ok("Test Task updated");
    }

    @GetMapping("/allTestTask")
    public ResponseEntity<List<TestTask>> getAllTestTask() {
        List<TestTask> testTasks = testTaskService.getAllTestTask();
        if (!testTasks.isEmpty()) {
            return ResponseEntity.ok().body(testTasks);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<TestTask> getSingleTestTaskById(@PathVariable int id) {
        Optional<TestTask> optionalTestTask = Optional.ofNullable(testTaskService.getTestTaskByIdTestTask(id));
        return optionalTestTask.map(application -> ResponseEntity.ok().body(application)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/find/name/{testTaskName}")
    public ResponseEntity<TestTask> getTestTaskByTestTaskName(@PathVariable String testTaskName) {
        TestTask testTask = testTaskService.getTestTaskByTestTaskName(testTaskName);
        if (testTask == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(testTask);
        }
    }

    @GetMapping("/find/byUserEmployee/{idUserEmployee}")
    public ResponseEntity<List<TestTask>> getTestTaskByIdUserEmployee(@PathVariable UserEmployee idUserEmployee) {
        List<TestTask> testTaskList = testTaskService.getTestTaskByIdUserEmployee(idUserEmployee);
        if (!testTaskList.isEmpty()) {
            return ResponseEntity.ok().body(testTaskList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/byBinary/{idBinary}")
    public ResponseEntity<List<TestTask>> getTestTaskByIdBinary(@PathVariable Binary idBinary) {
        List<TestTask> testTaskList = testTaskService.getTestTaskByIdBinary(idBinary);
        if (!testTaskList.isEmpty()) {
            return ResponseEntity.ok().body(testTaskList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/byTestTaskStatus/{testTaskStatus}")
    public ResponseEntity<List<TestTask>> getTestTaskByTesttaskStatus(@PathVariable TestTaskStatus testTaskStatus) {
        List<TestTask> testTaskList = testTaskService.getTestTaskByTestTaskStatus(testTaskStatus);
        if (!testTaskList.isEmpty()) {
            return ResponseEntity.ok().body(testTaskList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
