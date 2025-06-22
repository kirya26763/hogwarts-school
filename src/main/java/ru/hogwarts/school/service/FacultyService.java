package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Факультет с id " + id + " не найден"));
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty updateFaculty(Faculty faculty) {
        if (!facultyRepository.existsById(faculty.getId())) {
            throw new NoSuchElementException("Факультет с id " + faculty.getId() + " не найден");
        }
        return facultyRepository.save(faculty);
    }

    public Faculty deleteFaculty(Long id) {
        Faculty removed = getFaculty(id);
        facultyRepository.deleteById(id);
        return removed;
    }

    public Collection<Faculty> findFacultiesByColor(String color) {
        return facultyRepository.findAll()
                .stream()
                .filter(faculty -> faculty.getColor().equalsIgnoreCase(color))
                .toList();
    }
}