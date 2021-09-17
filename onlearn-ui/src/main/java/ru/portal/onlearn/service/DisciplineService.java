package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DisciplineDTO;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.repo.DisciplineRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface DisciplineService {


    Optional<DisciplineDTO> findDisciplineById(Long id);

    List<DisciplineDTO> findAllDiscipline();

    Page<DisciplineDTO> findByTitle(String title, Integer page, Integer size);


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
