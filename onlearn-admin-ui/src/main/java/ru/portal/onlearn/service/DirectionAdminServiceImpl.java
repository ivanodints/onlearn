package ru.portal.onlearn.service;


import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.repo.DirectionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectionAdminServiceImpl implements DirectionAdminService {

    private final DirectionRepository directionRepository;

    public DirectionAdminServiceImpl(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    @Override
    public List<DirectionAdminDTO> findAllDirection() {

        return directionRepository.findAll()
                .stream()
                .map(direction -> new DirectionAdminDTO(direction))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DirectionAdminDTO> findDirectionById(Long id) {
        return directionRepository.findById(id)
                .map(direction -> DirectionAdminService.mapToAdminDirectionDTO(direction));
    }

    @Override
    public Direction findByTitle(String title) {

        return directionRepository.findByTitle(title);
    }

    @Override
    public void deleteDirectionById(Long id) {
        directionRepository.deleteById(id);
    }


}
