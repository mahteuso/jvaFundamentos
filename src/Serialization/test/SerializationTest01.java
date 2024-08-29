package Serialization.test;

import Serialization.domain.Group;
import Serialization.domain.Student;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationTest01 {
    public static void main(String[] args) {

        Student mateus = new Student(1L, "Mateus Laranjeira", "surftesk8");
        Group group = new Group("Minha nova turma");

        mateus.setGroup(group);
        serialize(mateus);
        System.out.println(deserialize());
    }

    private static void serialize(Student student) {
        Path path = Paths.get("pasta/student.is");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String deserialize() {
        Path path = Paths.get("pasta/student.is");
        try (ObjectInput ois = new ObjectInputStream(Files.newInputStream(path))) {
            Student student = (Student) ois.readObject();
            return student.toString();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
