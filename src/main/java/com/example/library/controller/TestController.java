package com.example.library.controller;

import com.example.library.dto.JokeResponse;
import com.example.library.dto.TextResponse;
import com.example.library.entity.Joke;
import com.example.library.repository.JokeRepository;
import com.example.library.service.JokeClient;
import com.example.library.service.TranslatorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final JokeClient jokeClient;
    private final JokeRepository jokeRepository;
    private final TranslatorClient translatorClient;

    @GetMapping
    public List<Joke> getJoke(@RequestParam(required = false) String text) {
        if (text == null) {
            return jokeRepository.findAll();
        }

        return jokeRepository.findBySetupStartsWith(text);
    }

    @PostMapping("/translate")
    public Joke test(@RequestParam String sl, @RequestParam String dl) {
        JokeResponse jokeResponse = jokeClient.getRandomJoke();
        TextResponse punchLine = translatorClient.translate(sl, dl, jokeResponse.getPunchline());
        TextResponse type = translatorClient.translate(sl, dl, jokeResponse.getType());
        TextResponse setup = translatorClient.translate(sl, dl, jokeResponse.getSetup());
        Joke joke = new Joke();
        joke.setPunchline(punchLine.getDestinationText());
        joke.setType(type.getDestinationText());
        joke.setSetup(setup.getDestinationText());
        return jokeRepository.save(joke);
    }


    @PostMapping
    public JokeResponse test() {
        JokeResponse jokeResponse = jokeClient.getRandomJoke();

        Joke joke = new Joke();
        joke.setType(jokeResponse.getType());
        joke.setSetup(jokeResponse.getSetup());
        joke.setPunchline(jokeResponse.getPunchline());
        jokeRepository.save(joke);
        return jokeClient.getRandomJoke();
    }

}
