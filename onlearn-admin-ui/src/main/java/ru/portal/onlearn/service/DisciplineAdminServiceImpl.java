package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DisciplineAdminDTO;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.specification.DisciplineSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplineAdminServiceImpl implements DisciplineAdminService{

    private final DisciplineRepository disciplineRepository;

    public DisciplineAdminServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public Optional<DisciplineAdminDTO> findDisciplineById(Long id){
        return disciplineRepository.findById(id).map(discipline -> DisciplineAdminService.mapToAdminDisciplineDTO(discipline));
    }

    @Override
    public List<DisciplineAdminDTO> findAllDiscipline(){
        return disciplineRepository.findAll()
                .stream()
                .map(discipline -> new DisciplineAdminDTO(discipline))
                .collect(Collectors.toList());
    }

    @Override
    public Page<DisciplineAdminDTO> findDisciplineTitle(String title, Integer page, Integer size){
        Specification<Discipline> spec = Specification.where(null);

        if (title != null){
            spec = spec.and(DisciplineSpecification.byTitle(title));
        }

        Page<Long> ids = disciplineRepository.findAll(PageRequest.of(page - 1, size))
                .map(Discipline::getId);

        List<DisciplineAdminDTO> allByIds = disciplineRepository.findAll().stream()
                .map(discipline -> DisciplineAdminService.mapToAdminDisciplineDTO(discipline))
                .collect(Collectors.toList());
        return new PageImpl<>(allByIds, PageRequest.of(page -1, size), ids.getTotalElements());
    }

    @Override
    public void deleteDisciplineById(Long id) {
        disciplineRepository.deleteById(id);
    }
}
