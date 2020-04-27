package it.formarete.mvc.observer;

import it.formarete.mvc.Model;
import it.formarete.mvc.Observable;
import it.formarete.mvc.Observer;
import it.formarete.mvc.View;
import it.formarete.mvc.inheritance.ObservableModel;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InheritanceTest {

    @Test
    public void testObserver() {
        Observable observable = new ObservableModel();
        Observer observer = new View();
        observable.addObserver(observer);

        Model model = (Model) observable;
        View view = (View) observer;

        model.setAttribute("world");
        assertEquals("<h1>Hello world!</h1>", view.getOutput());
    }
}
