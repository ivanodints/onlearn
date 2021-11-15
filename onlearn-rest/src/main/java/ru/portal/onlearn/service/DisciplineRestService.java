package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DisciplineRestDTO;
import ru.portal.onlearn.model.Discipline;

import java.util.List;
import java.util.Optional;

@Service
public interface DisciplineRestService {

    Optional<DisciplineRestDTO> findDisciplineById(Long id);

    List<DisciplineRestDTO> findAllDiscipline();


    public static DisciplineRestDTO mapToDTO(Discipline discipline) {
        return new DisciplineRestDTO(
                discipline.getId(),
                discipline.getTitle(),
                discipline.getDiscTime(),
                discipline.getDescription(),
                discipline.getFaculty()
        );
    }
}
