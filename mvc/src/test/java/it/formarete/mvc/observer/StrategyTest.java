package it.formarete.mvc.observer;

import it.formarete.mvc.Observer;
import it.formarete.mvc.View;
import it.formarete.mvc.strategy.ModelWithObservable;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StrategyTest {

    @Test
    public void testObserver() {
        ModelWithObservable model = new ModelWithObservable();
        Observer observer = new View();
        model.addObserver(observer);

        View view = (View) observer;
        model.setAttribute("world");
        assertEquals("<h1>Hello world!</h1>", view.getOutput());
    }
}
