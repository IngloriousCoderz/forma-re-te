package it.formarete.mvc;

public class Controller {

	private Model model;
	private View view;

	public void setModel(Model model) {
		this.model = model;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void handleInput(String input) {
		model.setAttribute(input);
		String attribute = model.getAttribute();
		view.update(attribute);
	}
}
