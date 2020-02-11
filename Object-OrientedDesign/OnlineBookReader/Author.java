package OnlineBookReader;

import java.util.List;
import java.util.Map;

public class Author {
	private String firstName;
	private String lastName;
	private Map<Integer, Book> books;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void addBook(Book book) {
		books.put(books.size(), book);
	}

	public boolean removeBook(Book book) {
		if (books.containsKey(book)) {
			books.remove(book);
			return true;
		}
		return false;
	}

	public Book getBook(Book id) {
		return books.get(id);
	}

	public List<Book> getBooks() {
		return (List<Book>) books.values();
	}

}
