package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Студент с id " + id + " не найден"));
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        if (!studentRepository.existsById(student.getId())) {
            throw new NoSuchElementException("Студент с id " + student.getId() + " не найден");
        }
        return studentRepository.save(student);
    }

    public Student deleteStudent(Long id) {
        Student removed = getStudent(id); // выбросит исключение, если не найден
        studentRepository.deleteById(id);
        return removed;
    }

    public Collection<Student> findStudentsByAge(int age) {
        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getAge() == age)
                .toList();
    }
}