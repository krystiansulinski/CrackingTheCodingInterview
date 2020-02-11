package OnlineBookReader;

import java.util.Set;

public class Library {
	private Set<Author> authors;

	public Book getBook(Book id, Author author) {
		return author.getBook(id);
	}

	public void addBook(Book book, Author author) {
		author.addBook(book);
	}
	
	public void removeBook(Book book, Author author) {
		author.removeBook(book);
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

}
