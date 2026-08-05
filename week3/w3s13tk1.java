import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> pq = new PriorityQueue<Student>(
            new Comparator<Student>() {
                public int compare(Student s1, Student s2) {
                    int cgpaCompare = Double.compare(s2.getCGPA(), s1.getCGPA());
                    if (cgpaCompare != 0) return cgpaCompare;

                    int nameCompare = s1.getName().compareTo(s2.getName());
                    if (nameCompare != 0) return nameCompare;

                    return Integer.compare(s1.getID(), s2.getID());
                }
            }
        );

        for (String event : events) {
            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);

                pq.offer(new Student(id, name, cgpa));
            } else {
                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }

        List<Student> result = new ArrayList<Student>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}
