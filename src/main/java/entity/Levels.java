package entity;

public class Levels {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder newBuilder() {
        return new Levels().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Levels.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Levels.this.name = name;
            return this;
        }

        public Levels build() {
            return Levels.this;
        }
    }
}
