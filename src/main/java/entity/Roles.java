package entity;

public class Roles {
    private int id;
    private String name;

    private Roles() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Builder newBuilder() {
        return new Roles().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Roles.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Roles.this.name = name;
            return this;
        }

        public Roles build() {
            return Roles.this;
        }
    }
}
