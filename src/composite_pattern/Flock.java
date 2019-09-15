package composite_pattern;

import quack.Quackable;
import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    ArrayList quackers = new ArrayList();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator iterator = quackers.iterator();
        boolean isLeader = true;
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable)iterator.next();
            if (isLeader == true) {
                isLeader = false;
                quacker.quack();
                quacker.quack();
            }
            quacker.quack();
        }
    }
}
