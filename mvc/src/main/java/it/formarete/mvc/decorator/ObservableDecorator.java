package it.formarete.mvc.decorator;

import it.formarete.mvc.Model;
import it.formarete.mvc.Observable;

public class ObservableDecorator extends Observable implements Model {

    private Model decorated;

    public ObservableDecorator(Model decorated) {
        this.decorated = decorated;
    }

    @Override
    public String getAttribute() {
        return decorated.getAttribute();
    }

    @Override
    public void setAttribute(String attribute) {
        decorated.setAttribute(attribute);
        publish(attribute);
    }
}
