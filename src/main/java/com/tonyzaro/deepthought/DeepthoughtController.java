// Copyright 2024 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.tonyzaro.deepthought;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// Spring will find all RestControllers in the same package+sub-package as the main appliaction
@RestController
public class DeepthoughtController {

  private Map<String, Answer> db = new HashMap<>() {{
    put("1", new Answer("1", "Mean of life, universe & everything?", "42"));
    put("2", new Answer("2", "The perfect age?", "42"));
    put("3", new Answer("3", "Number of ppl who will use this API?", "42"));
  }};

  @GetMapping("/")
  public String theAnswerToAllQuestions(){
    return "The answer to all questions is ... 42";
  }

  @GetMapping("/answers")
  public Collection<Answer> get(){
    return db.values();
  }

  @GetMapping("/answers/{id}")
  public Answer get(@PathVariable String id){
    Answer answer =  db.get(id);
    if (answer == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return answer;
  }

  @DeleteMapping("/answers/{id}")
  public void delete(@PathVariable String id){
    Answer answer =  db.remove(id);
    if (answer == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/answers")
  public Answer create(@RequestBody Answer answer){
    //@RequestBody takes JSON and converts it to Answer object

    //don't let clients set the ID, we do that
    answer.setId(UUID.randomUUID().toString());
    //The answer to every question is 42...
    answer.setAnswer("42");
    db.put(answer.getId(), answer);
    return answer;
  }

}
