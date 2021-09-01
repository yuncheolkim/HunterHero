package co;

import java.util.ArrayList;
import java.util.List;

/**
 * 车
 */
class Car {
    public void dis() {
        System.out.println("car");
    }
}

class Tank extends Car {
    public void dis() {
        System.out.println("tank");
    }

    public void bomb() {
        System.out.println("bomb");
    }
}

/**
 * 标准车
 */
class Car1 extends Car {
    public void dis() {
        System.out.println("car1");
    }

    public void c1() {
        System.out.println("c1");
    }
}

/**
 * 高级车
 */
class Car2 extends Car1 {
    public void dis() {
        System.out.println("car2");
    }

    public void c2() {
        System.out.println("c2");
    }
}

public class FirstTest {


    public static List<Car> make() {
//        return new ArrayList<Car1>();
        return null;
    }

    public static void fix(List<Car> s) {
    }

    /**
     * 表示 只要来的是标准车 或者高级车 我都能修
     * 但是这样很奇怪, 标准车是车的子类, 却能修标准车却修不了车?
     * 车有的功能 标准车应该都有
     * 所以这里这样设定不符合逻辑
     * 所以一般这里 Car1 改为 Car
     * 但是这里不能对s 进行添加操作, 只能读取对象
     *
     * @param s 协变
     */
    public static void fix1(List<? extends Car1> s) {
        // 这种情况适合用协变
        cars1.addAll(s);
        // error
        // s.add(new Car2());
        for (Car1 c : s) {
            if (c instanceof Car2) {// 这种写法一般都不会出现, 因为你做为提供方法的一方,不知道有哪些子类
                ((Car2) c).c2();
            } else {
                c.c1();
            }
        }
        // 在这函数内只能对s 进行消费,不能对s进行修改
        // 主要原因是s 的具体泛型的类型无法确定,可以认为是没有一个边界

    }

    static List<Car1> cars1 = new ArrayList<>();

    /**
     * 在这里表示, 我只能修标准车以上的车, 而高级车则不能修理
     * 这里的的设定就比较符合逻辑
     * 但是一般都不会这么做, 因为我们都会希望用一个通用的方法处理各种个数的情况
     * 现在这样就反过来了, 用特殊的情况来处理通用的情况
     *
     * @param s 逆变
     */
    public static void fix2(List<? super Car1> s) {
        // 可以进行添加, 因外外部 泛型一定会变现为Car1的父类, 所以外部list能够处理 Car1, 则一定能处理所有Car1子类的对象
        s.add(new Car1());
        s.add(new Car2());

        // error 这里如果可以的话, 假设 s是:List<Car1>, 那么给这list添加 Car 会导致异常
        // 外部list会对Car 当作 Car1来处理
        // 但是Car不能完全当作Car1来处理
        // s.add(new Car());
    }

    public static void main(String[] args) {
        //
        List<Object> list = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        List<Car1> carList1 = new ArrayList<>();
        List<Car2> carList2 = new ArrayList<>();
        carList2.add(new Car2());
        carList1.addAll(carList1);

        // fix(carList2); error

//        fix1(carList); error
        fix1(carList1);
        fix1(carList2);

        fix2(carList);
        fix2(carList1);
//        fix2(carList2); error

    }
}
