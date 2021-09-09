package entity;

public class Labels {
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
        return new Labels().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Labels.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Labels.this.name = name;
            return this;
        }

        public Labels build() {
            return Labels.this;
        }
    }
}
