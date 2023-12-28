package com.telusko.questionservice.dao;

import com.telusko.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> { //JPA Repo will do all the fetching and saving ... + it demands 2 things : our table name and the type of its primary key!
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true) // when we don't have a personalized method within JPA Repository, we can create it, and here we give the SQL query we will need for this method!
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
