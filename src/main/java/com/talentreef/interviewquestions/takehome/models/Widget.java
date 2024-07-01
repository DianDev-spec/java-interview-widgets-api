package com.talentreef.interviewquestions.takehome.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Document(collection = "widgets")
public class Widget {

  @Id
  @Indexed(unique = true)
  @Size(min = 3, max = 100)
  @NotNull
  private String name;

  @Size(min = 5, max = 1000)
  @NotEmpty
  private String description;

  @DecimalMin(value = "1.00", inclusive = true)
  @DecimalMax(value = "20000.00", inclusive = true)
  @Digits(integer = 5, fraction = 2)
  @NotEmpty
  private BigDecimal price;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  // Constructor
  public Widget(String name, String description, BigDecimal price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String name;
    private String description;
    private BigDecimal price;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder price(BigDecimal price) {
      this.price = price;
      return this;
    }

    public Widget build() {
      return new Widget(name, description, price);
    }
  }
}
