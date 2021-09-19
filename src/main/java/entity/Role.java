package entity;

public class Role {
    private int id;
    private String name;

    private Role() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Builder newBuilder() {
        return new Role().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Role.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Role.this.name = name;
            return this;
        }

        public Role build() {
            return Role.this;
        }
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
