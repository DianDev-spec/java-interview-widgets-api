package com.talentreef.interviewquestions.takehome.services;

import com.talentreef.interviewquestions.takehome.exceptions.ResourceNotFoundException;
import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {
  @Autowired
  private WidgetRepository widgetRepository;

  public Widget createWidget(Widget widget) {
    return widgetRepository.save(widget);
  }

  public List<Widget> getAllWidgets() {
    return widgetRepository.findAll();
  }

  public Optional<Widget> getWidgetByName(String name) {
    return widgetRepository.findByName(name);
  }

  public Widget updateWidget(String name, String description, BigDecimal price) {
    Widget widget = widgetRepository.findById(name).orElseThrow(() -> new ResourceNotFoundException("Widget not found"));
    widget.setDescription(description);
    widget.setPrice(price);
    return widgetRepository.save(widget);
  }

  public void deleteWidget(String id) {
    widgetRepository.deleteById(id);
  }
}
