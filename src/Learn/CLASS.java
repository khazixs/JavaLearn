package Learn;

public class CLASS {
    int id;
    String sname;
    int age;

    void study() {
        System.out.println(age + "岁的" + sname + "在认真学习！！");
    }

    void play() {
        System.out.println("我在海岛旅行！！");
    }

    public static void main(String[] args) {
        CLASS stu1 = new CLASS();
        stu1.id = 1001;
        stu1.age = 18;
        stu1.sname = "宝贝";

        stu1.study();
    }
}
