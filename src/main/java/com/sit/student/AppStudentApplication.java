package com.sit.student;

import com.sit.student.model.Classes;
import com.sit.student.model.Discipline;
import com.sit.student.model.Student;
import com.sit.student.service.ClassesService;
import com.sit.student.service.DisciplineService;
import com.sit.student.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AppStudentApplication {

    static Scanner in = new Scanner(System.in);
    static int choice = 0;

    public static void main(String[] args) {
//        SpringApplication.run(AppStudentApplication.class, args);

        ApplicationContext context = SpringApplication.run(AppStudentApplication.class);

        StudentService studentService = context.getBean(StudentService.class);
        DisciplineService disciplineService = context.getBean(DisciplineService.class);
        ClassesService classesService = context.getBean(ClassesService.class);

        boolean flag = false;
        do {
            try {
                System.out.println("1. Новый студент");
                System.out.println("2. Список студентов");
                System.out.println("3. Список дисциплин для...");
                System.out.println("4. Регистрация дисциплины");
                System.out.println("5. Новый урок");
                System.out.println("6. Список проведённых занятий для...");
                System.out.println("7. Выход");
                System.out.print("Ввод: ");
                choice = Integer.parseInt(in.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Введите Фамилию: ");
                        String sname = in.nextLine();
                        System.out.println("Введите Имя: ");
                        String fname = in.nextLine();
                        System.out.println("Введите Отчество: ");
                        String pname = in.nextLine();
                        Student student = new Student(sname, fname, pname);
                        studentService.save(student);
                        break;

                    case 2:
                        studentService.findAll().forEach(System.out::println);
                        break;

                    case 3:
                        studentService.findAll().forEach(System.out::println);
                        System.out.println("Укажите Ид студента, для которого необходимо вывести список дисциплин: ");
                        int idStudentDis = Integer.parseInt(in.nextLine());
                        disciplineService.getListDisciplinByStudentId(idStudentDis).forEach(System.out::println);
                        break;

                    case 4:
                        List<Student> students = studentService.findAll();
                        students.forEach(System.out::println);
                        System.out.println("Укажите Ид студента, для которого регистрируете дисциплину: ");
                        int id = Integer.parseInt(in.nextLine());

                        Student studentItem = students.stream()
                                .filter(a -> a.getId() == id)
                                .toList().get(0);

                        System.out.println("Введите наименование дисциплины: ");
                        String disName = in.nextLine();
                        System.out.println("Введите количество часов: ");
                        int hourMax = Integer.parseInt(in.nextLine());

                        Discipline discipline = new Discipline(studentItem, disName, hourMax);
                        disciplineService.save(discipline);
                        System.out.println("Успешно зарегистрировано");
                        break;

                    case 5:
                        List<Student> studentsForClass = studentService.findAll();
                        studentsForClass.forEach(System.out::println);
                        System.out.println("Укажите Ид студента, для которого регистрируете дисциплину: ");
                        int idClassStudent = Integer.parseInt(in.nextLine());

                        List<Discipline> disciplines = disciplineService.getListDisciplinByStudentId(idClassStudent);
                        disciplines.forEach(System.out::println);

                        System.out.println("Укажите Ид дисциплины, для регистрации занятия: ");
                        int idDiscipline = Integer.parseInt(in.nextLine());

                        Discipline disciplineItem = disciplines.stream()
                                .filter(a -> a.getId() == idDiscipline)
                                .toList().get(0);

                        System.out.println("Введите наименование урока: ");
                        String className = in.nextLine();
                        Classes classes = new Classes(disciplineItem, className);
                        classesService.saveClass(classes);

                        System.out.println("Успешно зарегистрировано");
                        break;

                    case 6:
                        List<Student> studentsListClass = studentService.findAll();
                        studentsListClass.forEach(System.out::println);
                        System.out.println("Укажите Ид студента: ");
                        int idListClassStudent = Integer.parseInt(in.nextLine());

                        List<Discipline> disciplinesItem = disciplineService.getListDisciplinByStudentId(idListClassStudent);
                        disciplinesItem.forEach(System.out::println);

                        System.out.println("Укажите Ид дисциплины для вывода списка проведённых занятий: ");
                        int idListDiscipline = Integer.parseInt(in.nextLine());
                        classesService.getListClassByDisciplineId(idListDiscipline).forEach(System.out::println);

                        break;

                    case 7:
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.err.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные!");
            }

        } while (!flag);
    }


}
