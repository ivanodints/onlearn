package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DisciplineDTO;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;

import java.util.List;
import java.util.Optional;

@Service
public interface DisciplineService {


    Optional<DisciplineDTO> findDisciplineById(Long id);

    List<DisciplineDTO> findAllDiscipline();

    Page<DisciplineDTO> findByTitle(String title, Integer page, Integer size);

    List<DisciplineDTO> findDisciplineByFaculty(Long id);

    public static DisciplineDTO mapToDTO(Discipline discipline) {
        return new DisciplineDTO(
                discipline.getId(),
                discipline.getTitle(),
                discipline.getDiscTime(),
                discipline.getDescription(),
                discipline.getFaculty(),
                discipline.getEmployees()
                );
    }
}
