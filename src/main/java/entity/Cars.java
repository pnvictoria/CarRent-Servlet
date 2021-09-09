package entity;

public class Cars {
    private int id;
    private String name;
    private int price;
    private String jpg;
    private String desc;
    private Labels label;
    private Levels level;

    private Cars() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getJpg() {
        return jpg;
    }

    public String getDesc() {
        return desc;
    }

    public Labels getLabel() {
        return label;
    }

    public Levels getLevel() {
        return level;
    }

    public static Builder newBuilder() {
        return new Cars().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Cars.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Cars.this.name = name;
            return this;
        }

        public Builder setPrice(int price) {
            Cars.this.price = price;
            return this;
        }

        public Builder setJpg(String jpg) {
            Cars.this.jpg = jpg;
            return this;
        }

        public Builder setDesc(String desc) {
            Cars.this.desc = desc;
            return this;
        }

        public Builder setLabel(Labels label) {
            Cars.this.label = label;
            return this;
        }

        public Builder setLevel(Levels level) {
            Cars.this.level = level;
            return this;
        }

        public Cars build() {
            return Cars.this;
        }
    }
}