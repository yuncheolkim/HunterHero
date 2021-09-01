package co;

import java.util.function.Consumer;

/**
 * @author Yunzhe.Jin
 * 2021/9/1 22:19
 */
public class TestConsume {

    public void process(Consumer<? super Cat> animalConsumer) {
        animalConsumer.accept(new Cat());
    }

    public static void main(String[] args) {
        TestConsume catMan = new TestConsume();

        Consumer<Cat> c = cat -> {
        };

        catMan.process(c);

    }
}


interface Animal {

}

class Cat implements Animal {
}

class Cat1 extends Cat {
}

class Dog implements Animal {
}
