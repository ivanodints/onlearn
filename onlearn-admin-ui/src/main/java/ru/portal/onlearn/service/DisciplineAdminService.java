package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DisciplineAdminDTO;
import ru.portal.onlearn.model.Discipline;

import java.util.List;
import java.util.Optional;

@Service
public interface DisciplineAdminService {

    Optional<DisciplineAdminDTO> findDisciplineById(Long id);

    List<DisciplineAdminDTO> findAllDiscipline();

    Page<DisciplineAdminDTO> findDisciplineTitle(String title, Integer page, Integer size);

    void deleteDisciplineById(Long id);

    public static DisciplineAdminDTO mapToAdminDisciplineDTO(Discipline discipline) {
        return new DisciplineAdminDTO(
                discipline.getId(),
                discipline.getTitle(),
                discipline.getDiscTime(),
                discipline.getDescription(),
                discipline.getFaculty(),
                discipline.getEmployees()
        );
    }

}
