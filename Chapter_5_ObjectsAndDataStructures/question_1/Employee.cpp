Class Employee
{
    string name;
    int age;
    float salary;

public:
    string getName();
    void setName(string name);
    int getAge();
    void setAge(int age);
    float getSalary();
    void setSalary(float salary);
};

// employee is a Data Structure because the Employee class only has data members with their respective getters and setters without business logic or behavior.
Employee employee;
