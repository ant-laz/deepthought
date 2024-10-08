package com.tonyzaro.deepthought;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring will find all RestControllers in the same package+sub-package as the main appliaction
@RestController
public class DeepthoughtController {

  @GetMapping("/")
  public String theAnswerToAllQuestions(){
    return "The answer to your question is ... 42";
  }

}
