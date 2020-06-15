package wpartone.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import wpartone.model.entity.Exercise;
import wpartone.model.service.ExerciseServiceModel;
import wpartone.repository.ExerciseRepository;
import wpartone.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;


    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addEx(ExerciseServiceModel exerciseServiceModel) {
        this.exerciseRepository.saveAndFlush(this.modelMapper.map(exerciseServiceModel, Exercise.class));
    }
}
