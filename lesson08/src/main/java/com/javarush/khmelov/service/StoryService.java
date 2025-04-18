package com.javarush.khmelov.service;

import com.javarush.khmelov.mapper.StoryDto;
import com.javarush.khmelov.model.story.Story;
import com.javarush.khmelov.repository.impl.StoryRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StoryService {

    public final StoryRepoImpl repoImpl;
    public final StoryDto mapper;

    public List<Story.Out> getAll() {
        return repoImpl
                .getAll()
                .map(mapper::out)
                .toList();
    }

    public Story.Out get(Long id) {
        return repoImpl
                .get(id)
                .map(mapper::out)
                .orElseThrow();
    }

    public Story.Out create(Story.In input) {
        return repoImpl
                .create(mapper.in(input))
                .map(mapper::out)
                .orElseThrow();
    }

    public Story.Out update(Story.In input) {
        return repoImpl
                .update(mapper.in(input))
                .map(mapper::out)
                .orElseThrow();
    }

    public boolean delete(Long id) {
        return repoImpl.delete(id);
    }
}
