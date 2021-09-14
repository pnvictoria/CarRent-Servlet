package entity;

public class Users {
    private int id;
    private String name;
    private String surname;
    private boolean sex;
    private String date;
    private String email;
    private String password;
    private Roles role;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isSex() {
        return sex;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", date='" + date + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public static Builder newBuilder() {
        return new Users().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(int id) {
            Users.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Users.this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            Users.this.surname = surname;
            return this;
        }

        public Builder setSex(boolean sex) {
            Users.this.sex = sex;
            return this;
        }

        public Builder setDate(String date) {
            Users.this.date = date;
            return this;
        }

        public Builder setEmail(String email) {
            Users.this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            Users.this.password = password;
            return this;
        }

        public Builder setRole(Roles role) {
            Users.this.role = role;
            return this;
        }

        public Users build() {
            return Users.this;
        }
    }
}
