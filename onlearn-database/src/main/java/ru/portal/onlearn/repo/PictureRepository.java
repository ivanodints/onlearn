package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
