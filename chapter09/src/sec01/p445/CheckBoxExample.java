package sec01.p445;

public class CheckBoxExample {

	public static void main(String[] args) {
		CheckBox checkBox = new CheckBox();
		checkBox.setOnSelectListener(new BackgroundChangeListener());
		checkBox.select();
	}

}
