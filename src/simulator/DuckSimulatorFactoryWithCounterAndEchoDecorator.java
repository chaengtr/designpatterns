package simulator;

import factory.AbstractDuckFactory;
import factory.CountingAndEchoDuckFactory;
import goose.Goose;
import goose.GooseAdapter;
import pigeon.Pigeon;
import pigeon.PigeonAdapter;
import quack.QuackCounter;
import quack.Quackable;

public class DuckSimulatorFactoryWithCounterAndEchoDecorator {
    public static void main(String[] args) {
        DuckSimulatorFactoryWithCounterAndEchoDecorator simulator = new DuckSimulatorFactoryWithCounterAndEchoDecorator();
        AbstractDuckFactory duckFactory = new CountingAndEchoDuckFactory();

        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator: With Abstract Factory (Counter and Echo Decorator)");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeon);
        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
