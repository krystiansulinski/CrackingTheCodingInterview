package OnlineBookReader;

public class User {
	private int userId;

	public User(int id) {
		this.userId = id;
	}

	public void readBook(Book book, Author author) {
		getLibrary().getBook(book, author);
	}

	public Library getLibrary() {
		return null;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
