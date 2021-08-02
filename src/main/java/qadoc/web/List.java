package qadoc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import qadoc.repository.TestRepository;

@Controller
public class List {

  @Autowired
  private TestRepository testRepository;

  @GetMapping("/list")
  public String list(Model model) {

    model.addAttribute("Test", testRepository.findAll());

    return "list";
  }

  // @GetMapping("/single")
  // public String single(@PathVariable(value = "name") Long name) {

  //   model.addAttribute("Test", testRepository.findByName(name));

  //   return "single";
  // }

}