class User implements Comparable<User> {
    private final int userNo;
    private final String userName;
    private final int userAge;

    public User(int userNo, String userName, int userAge) {
        this.userNo = userNo;
        this.userName = userName;
        this.userAge = userAge;
    }

    public int getUserNo() {
        return userNo;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    @Override
    public int compareTo(User user) {
        return this.userNo - user.userNo;
    }

    @Override
    public String toString() {
        return "User {" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}