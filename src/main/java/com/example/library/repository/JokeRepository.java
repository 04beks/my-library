package com.example.library.repository;

import com.example.library.entity.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JokeRepository extends JpaRepository<Joke, Long> {

    List<Joke> findBySetupStartsWith(String text);

}
