package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Faculty;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface DirectionAdminService {


    List<DirectionAdminDTO> findAllDirection();

    Optional<DirectionAdminDTO> findDirectionById(Long id);

    Direction findByTitle (String title);




    public static DirectionAdminDTO mapToDTO(Direction direction) {
        return new DirectionAdminDTO(
                direction.getId(),
                direction.getTitle(),
                direction.getDescription(),
                direction.getFaculties().size() > 0 ? direction.getFaculties().get(0).getId() : null,
                direction.getFaculties().stream().map(Faculty::getId).collect(Collectors.toList()));
    }

    void deleteProductById (Long id);

}
