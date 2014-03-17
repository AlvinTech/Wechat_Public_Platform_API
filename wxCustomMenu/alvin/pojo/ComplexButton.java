package alvin.pojo;

/**
 * 复杂按钮（父按钮）
 *
 * @author Alvin
 * @date 2013年12月27日 下午1:53:15
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}