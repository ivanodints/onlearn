package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionDTO;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Direction;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface DirectionService {


    List<DirectionDTO> findAllDirection();

    Optional<DirectionDTO> findDirectionById(Long id);

    DirectionDTO findByTitle (String title);


    public static DirectionDTO mapToDTO(Direction direction) {
        return new DirectionDTO(
                direction.getId(),
                direction.getTitle(),
                direction.getDescription(),
                direction.getFaculties().size() > 0 ? direction.getFaculties().get(0).getId() : null,
                direction.getFaculties().stream().map(Faculty::getId).collect(Collectors.toList()));
    }

}
