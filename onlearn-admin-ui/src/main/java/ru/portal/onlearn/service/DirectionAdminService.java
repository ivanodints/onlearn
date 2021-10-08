package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.controller.DTO.DirectionDTO;
import ru.portal.onlearn.controller.DTO.PictureDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Faculty;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface DirectionAdminService {


    List<DirectionAdminDTO> findAllDirection();

    Optional<DirectionAdminDTO> findDirectionById(Long id);

    Direction findByTitle (String title);

    static DirectionAdminDTO mapToAdminDirectionDTO(Direction direction) {
        return new DirectionAdminDTO(
                direction.getId(),
                direction.getTitle(),
                direction.getDescription(),
                direction.getPictures().stream().map(picture -> new PictureDTO(picture)).collect(Collectors.toList()));
    }

    void deleteDirectionById(Long id);

    void saveDirection (DirectionAdminDTO directionAdminDTO) throws IOException;

}
