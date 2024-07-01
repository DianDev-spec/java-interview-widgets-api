package com.talentreef.interviewquestions.takehome.controllers;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/widgets")
@CrossOrigin(origins = "http://localhost:3000")
public class WidgetController {
  @Autowired
  private WidgetService widgetService;

  @PostMapping
  public ResponseEntity<Widget> createWidget(@Valid @RequestBody Widget widget) {
    return new ResponseEntity<>(widgetService.createWidget(widget), HttpStatus.CREATED);
  }

  @GetMapping
  public List<Widget> getAllWidgets() {
    return widgetService.getAllWidgets();
  }

  @GetMapping("/{name}")
  public ResponseEntity<Widget> getWidgetByName(@PathVariable String name) {
    return widgetService.getWidgetByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{name}")
  public ResponseEntity<Widget> updateWidget(@PathVariable String name, @RequestBody Widget widgetDetails) {
    return ResponseEntity.ok(widgetService.updateWidget(name, widgetDetails.getDescription(), widgetDetails.getPrice()));
  }

  @DeleteMapping("/{name}")
  public ResponseEntity<Void> deleteWidget(@PathVariable String name) {
    widgetService.deleteWidget(name);
    return ResponseEntity.noContent().build();
  }
}
