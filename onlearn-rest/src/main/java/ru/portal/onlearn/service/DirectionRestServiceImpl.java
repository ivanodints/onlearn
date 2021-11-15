package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionRestDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.repo.DirectionRepository;

@Service
public class DirectionRestServiceImpl implements DirectionRestService {

    private final DirectionRepository directionRepository;

    public DirectionRestServiceImpl(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    @Override
    public List<DirectionRestDTO> findAllDirection() {

        return directionRepository.findAll()
                .stream()
                .map(direction -> new DirectionRestDTO(direction))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DirectionRestDTO> findDirectionById(Long id) {
        return directionRepository.findById(id).map(direction -> DirectionRestService.mapToDTO(direction));

    }

}
