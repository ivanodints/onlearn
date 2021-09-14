package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.EmployeeDTO;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.repo.EmployeeRepository;
import ru.portal.onlearn.repo.specification.EmployeeSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<EmployeeDTO> findById(Long id){
        return employeeRepository.findById(id)
                .map(EmployeeService::mapToDTO);
    }

    @Override
    public Page<Employee> findAll(){
        return new PageImpl<>(employeeRepository.findAll());
    }

    @Override
    public Page<EmployeeDTO> findByFilter(String surname, Integer page, Integer size){
        Specification<Employee> spec = Specification.where(null);
        if (surname != null){
            spec = spec.and(EmployeeSpecification.bySurname(surname));
        }

        Page<Long> ids = employeeRepository.findAll(PageRequest.of(page - 1, size))
                .map(Employee::getId);

        List<EmployeeDTO> allByIds = employeeRepository.findAll().stream()
                .map(EmployeeService::mapToDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(allByIds, PageRequest.of(page -1, size), ids.getTotalElements());
    }
}
