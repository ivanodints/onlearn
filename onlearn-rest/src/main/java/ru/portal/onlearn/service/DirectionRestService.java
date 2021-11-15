package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionRestDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Faculty;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface DirectionRestService {

    List<DirectionRestDTO> findAllDirection();

    Optional<DirectionRestDTO> findDirectionById(Long id);

    public static DirectionRestDTO mapToDTO(Direction direction) {
        return new DirectionRestDTO(
                direction.getId(),
                direction.getTitle(),
                direction.getDescription()
        );

    }
}
