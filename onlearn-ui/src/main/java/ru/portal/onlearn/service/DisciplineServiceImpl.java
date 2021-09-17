package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DisciplineDTO;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.specification.DisciplineSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public DisciplineServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public List<DisciplineDTO> findAllDiscipline(){
        return disciplineRepository.findAll()
                .stream()
                .map(discipline -> new DisciplineDTO(discipline))
                .collect(Collectors.toList());
    }


    @Override
    public Optional<DisciplineDTO> findDisciplineById(Long id){
        return disciplineRepository.findById(id).map(discipline -> DisciplineService.mapToDTO(discipline));
    }


    @Override
    public Page<DisciplineDTO> findByTitle(String title, Integer page, Integer size){
        Specification<Discipline> spec = Specification.where(null);

        if (title != null){
            spec = spec.and(DisciplineSpecification.byTitle(title));
        }

        Page<Long> ids = disciplineRepository.findAll(PageRequest.of(page - 1, size))
                .map(Discipline::getId);

        List<DisciplineDTO> allByIds = disciplineRepository.findAll().stream()
                .map(DisciplineService::mapToDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(allByIds, PageRequest.of(page -1, size), ids.getTotalElements());
    }

}
