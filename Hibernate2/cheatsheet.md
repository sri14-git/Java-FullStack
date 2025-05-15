In Hibernate (and JPA), relationships between entities are modeled using annotations like `@OneToMany`, `@ManyToOne`, and `@ManyToMany`. These annotations define how entities are related in the database and how Hibernate should manage those relationships.

---

## 🔁 1. `@OneToMany` (One entity → Many others)

This represents a **one-to-many** relationship: one entity has a collection of many other entities.

### ✅ Example: One Department has many Employees

```java
@Entity
public class Department {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
}
```

```java
@Entity
public class Employee {

    @Id
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id") // foreign key in the employee table
    private Department department;
}
```

### 🔹 Notes:

* `mappedBy` is used on the *non-owning side* (`Department`), meaning the `Employee` table will have the foreign key (`department_id`).
* Use `cascade = CascadeType.ALL` if you want to save/delete employees along with the department.

---

## 🔁 2. `@ManyToOne` (Many entities → One)

This is the **inverse** of `@OneToMany`.

### ✅ Example: Many Employees belong to one Department

```java
@Entity
public class Employee {

    @Id
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")  // The foreign key column in Employee table
    private Department department;
}
```

This side **owns** the relationship and contains the foreign key in the database.

---

## 🔁 3. `@ManyToMany` (Many entities ↔ Many entities)

This is used when **many entities relate to many other entities**, e.g., a student can enroll in many courses, and a course can have many students.

### ✅ Example: Students and Courses

```java
@Entity
public class Student {

    @Id
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();
}
```

```java
@Entity
public class Course {

    @Id
    private int id;
    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}
```

### 🔹 Notes:

* `@JoinTable` defines the **join table** (`student_course`) that holds both foreign keys.
* The `mappedBy` in `Course` tells Hibernate that `Student` owns the relationship.

---

## 🧠 Summary Table:

| Relationship  | Description | Where is FK Stored?      | Needs Join Table? |
| ------------- | ----------- | ------------------------ | ----------------- |
| `@OneToMany`  | One → Many  | In the "many" side       | ❌ No              |
| `@ManyToOne`  | Many → One  | In the "many" side       | ❌ No              |
| `@ManyToMany` | Many ↔ Many | In a separate join table | ✅ Yes             |

---

Let me know if you'd like a working Java + Hibernate example for any of these!
