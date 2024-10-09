package com.tonyzaro.deepthought;

public class Answer {
  private String id;
  private String question;
  private String answer;

  public String getId() {
    return id;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public Answer(String id, String question, String answer) {
    this.id = id;
    this.question = question;
    this.answer = answer;
  }

  public Answer() {
  }
}
