package lv.tsi.hello;

public class Greeting {

	private final String content;

	public Greeting(long id, String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
