public class MyFirstClass {
    private String name;
    private Integer Age;

    public MyFirstClass()
    {

    }

    public MyFirstClass(String name, Integer age)
    {
        this.name = name;
        this.Age = age;
    }

    public String returnString(String name, Integer age)
    {
        return "Name is: " + name + ", age is : " + age;
    }
}
