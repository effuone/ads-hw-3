package edu.astanait;
public class MyTestingClass {
    private final int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        // Custom hash code function for uniform distribution
        return Integer.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return id == that.id;
    }

    @Override
    public String toString() {
        return "ID: " + id;
    }
}

