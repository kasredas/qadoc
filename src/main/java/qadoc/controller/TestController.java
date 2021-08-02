package qadoc.controller;

import java.util.List;

import javax.validation.Valid;

import qadoc.exception.ResourceNotFoundException;
import qadoc.model.Test;
import qadoc.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

  @Autowired
  private TestRepository testRepository;

  @GetMapping("/tests")
  public List<Test> getAllUsers() {
    return testRepository.findAll();
  }

  @GetMapping("/test/{id}")
  public ResponseEntity<Test> getTestsBy(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    Test test = testRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Test not found with id: " + id));
    return ResponseEntity.ok().body(test);
  }

  @PostMapping("/test")
  public Test inlcudeTest(@Valid @RequestBody Test testDetails) throws ResourceNotFoundException {
    String testName = testDetails.getName();
    List<Test> existingTest = testRepository.findByName(testName);

    if (existingTest.size() > 0) {

      // Update existing test when there is existing record ( matching by name)

      Test test = testRepository.findById(existingTest.get(0).getId())
          .orElseThrow(() -> new ResourceNotFoundException("Test not found with ID: " + existingTest.get(0).getId()));

      test.setName(existingTest.get(0).getName());
      test.setDescription(testDetails.getDescription());

      return testRepository.save(test);

    } else {
      // Save as a new record when there is no existing (by name) test
      return testRepository.save(testDetails);
    }

  }

}
