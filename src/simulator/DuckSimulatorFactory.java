package simulator;

import factory_pattern.AbstractDuckFactory;
import factory_pattern.DuckFactory;
import goose.Goose;
import goose.GooseAdapter;
import pigeon.Pigeon;
import pigeon.PigeonAdapter;
import quack.QuackCounter;
import quack.Quackable;

public class DuckSimulatorFactory {
    public static void main(String[] args) {
        DuckSimulatorFactory simulator = new DuckSimulatorFactory();
        AbstractDuckFactory duckFactory = new DuckFactory();

        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = new QuackCounter(duckFactory.createMallardDuck());
        Quackable redheadDuck = new QuackCounter(duckFactory.createRedheadDuck());
        Quackable duckCall = new QuackCounter(duckFactory.createDuckCall());
        Quackable rubberDuck = new QuackCounter(duckFactory.createRubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator: With Abstract Factory (No Decorator)");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);
        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}

