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

        public void setId(int id) {
            Cars.this.id = id;
        }

        public void setName(String name) {
            Cars.this.name = name;
        }

        public void setPrice(int price) {
            Cars.this.price = price;
        }

        public void setJpg(String jpg) {
            Cars.this.jpg = jpg;
        }

        public void setDesc(String desc) {
            Cars.this.desc = desc;
        }

        public void setLabel(Labels label) {
            Cars.this.label = label;
        }

        public void setLevel(Levels level) {
            Cars.this.level = level;
        }

        public Cars build() {
            return Cars.this;
        }
    }
}