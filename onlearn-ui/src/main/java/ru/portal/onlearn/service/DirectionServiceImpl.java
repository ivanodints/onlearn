package ru.portal.onlearn.service;


import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.repo.DirectionRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectionServiceImpl implements DirectionService {

    private final DirectionRepository directionRepository;

    public DirectionServiceImpl(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    @Override
    public List<DirectionDTO> findAllDirection() {

        return directionRepository.findAll()
                .stream()
                .map(direction -> new DirectionDTO(direction))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DirectionDTO> findDirectionById(Long id) {
        return directionRepository.findById(id)
                .map(direction -> DirectionService.mapToDTO(direction));
    }


    @Override
    public DirectionDTO findByTitle(String title) {

        DirectionDTO directionDTO = new DirectionDTO(directionRepository.findByTitle(title));

        return directionDTO;
    }


}
