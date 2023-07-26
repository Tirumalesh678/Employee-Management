package com.example.backend.service;

import com.example.backend.entity.Student;
import com.example.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents()
    {
        List<Student> students=studentRepository.findAll();
        return students;
    }


    public Student findById(Long id)
    {
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(studentOptional.isEmpty())
        {
            throw new RuntimeException("student with id not exist");
        }

        return studentOptional.get();
    }

    public Student findByName(String name)
    {
        return studentRepository.findByName(name);
    }

    public void saveStudent(Student student)
    {
        studentRepository.save(student);
    }

    public void updateStudent(Student student,Long id)
    {
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(studentOptional.isEmpty())
        {
            throw new RuntimeException("student with id not exist");
        }

        Student st=studentOptional.get();
        st.setFirstName(student.getFirstName());
        st.setLastName(student.getLastName());
        studentRepository.save(st);
    }

}
