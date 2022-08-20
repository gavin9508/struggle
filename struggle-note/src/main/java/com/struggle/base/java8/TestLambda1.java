package com.struggle.base.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author sly
 * @Date 2022/8/3 22:40
 * @Description
 */
public class TestLambda1 {
    // 创建集合对象
    static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9090.90),
            new Employee("王武", 35, 4567.90),
            new Employee("王二", 45, 9090.90),
            new Employee("李四", 34, 567.90),
            new Employee("小平", 18, 9090.90)
    );

    public static void main(String[] args) {
        //需求：获取当前公司中员工年龄大于35的员工信息
        List<Employee> employeeList = filterEmployees(employees);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        //优化方式1：使用策略模式
        //需求2：a：获取当前公司中员工年龄大于20的员工信息; b: 获取当前公司中员工工资大于5000的员工信息
        System.out.println("----------使用策略模式-------------");
        List<Employee> list1 = filterEmployee(employees, new FilterEmployeeBySalary());
        List<Employee> lists = filterEmployee(list1, new FilterEmployeeByAge());
        for (Employee employee : lists) {
            System.out.println(employee);
        }
        System.out.println("----------匿名内部类------------");
        //优化方式2：匿名内部类
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("---------lambda表达式-----------");
        //优化方式3：lambada表达式
        List<Employee> Employees = filterEmployee(employees, (e) -> e.getSalary() <= 5000);
        Employees.forEach(System.out::println);
        System.out.println("----------------------------");
        employees.stream()
                .filter((e)->e.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("---------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    /**
     * @param list 需要过滤的参数
     * @param mp   过滤的方法
     * @return
     */
    public static List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }

    public static List<Employee> filterEmployees(List<Employee> employees) {
        ArrayList<Employee> empty = new ArrayList<>();
        employees.forEach(employee -> {
            if (employee.getAge() >= 35) {
                empty.add(employee);
            }
        });
        return empty;
    }
}


interface MyPredicate<T> {

    boolean test(T t);
}


// 根据员工的年龄，过滤Employee
class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 20;
    }
}

// 根据员工的薪资，过滤Employee
class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000;
    }
}


class Employee {
    String name;
    int age;
    Double salary;

    public Employee() {
    }

    public Employee(String name, int age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}