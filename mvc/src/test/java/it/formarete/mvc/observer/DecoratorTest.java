package it.formarete.mvc.observer;

import it.formarete.mvc.Model;
import it.formarete.mvc.Observable;
import it.formarete.mvc.Observer;
import it.formarete.mvc.SimpleModel;
import it.formarete.mvc.View;
import it.formarete.mvc.decorator.ObservableDecorator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DecoratorTest {

    @Test
    public void testObserver() {
        Observable observable = new ObservableDecorator(new SimpleModel());
        Observer observer = new View();
        observable.addObserver(observer);

        Model model = (Model) observable;
        View view = (View) observer;
        model.setAttribute("world");
        assertEquals("<h1>Hello world!</h1>", view.getOutput());
    }
}
