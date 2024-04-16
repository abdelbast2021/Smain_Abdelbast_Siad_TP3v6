package exo1;

import java.util.Objects;

// User.java
public class User {
    private long id;
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Ajoutez les getters et setters si nécessaire

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User user = (User) obj;
        return id == user.id && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
