package com.talentreef.interviewquestions.takehome.repositories;

import com.talentreef.interviewquestions.takehome.models.Widget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WidgetRepository extends MongoRepository<Widget, String> {
    Optional<Widget> findByName(String name);
}
