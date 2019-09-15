package simulator;

import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RedheadDuck;
import ducks.RubberDuck;
import goose.Goose;
import goose.GooseAdapter;
import pigeon.Pigeon;
import pigeon.PigeonAdapter;
import quack.QuackCounter;
import quack.QuackEcho;
import quack.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }

    void simulate() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new QuackEcho(new DuckCall()));
        Quackable rubberDuck = new QuackEcho(new QuackCounter(new RubberDuck()));
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator");

//        simulate(mallardDuck);
//        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
//        simulate(gooseDuck);
//        simulate(pigeonDuck);

        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
