package Serialization.domain;

import java.io.*;
import java.util.Objects;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = -2737070134443632779L;
    private Long id;

    private String name;

    private transient String password;

    private static final String NAME_SCHOOL = "Ufscar minha segunda casa";

    private transient Group group;

    public Student(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            oos.writeUTF(group.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Serial
    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            String nameGroup = ois.readUTF();
            this.group = new Group(nameGroup);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", nameSchool='" + NAME_SCHOOL + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
