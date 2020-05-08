package Q7_05_Online_Book_Reader;

public class Display {
	private Book book;
	private int currentPage = 0;

	public void startReadingBook(Book book, Author author) {
	}

	public void stopReadingBook(Book book) {
	}

	public void turnPageForward() {
		setCurrentPage(getCurrentPage() + 1);
		refresh();
	}

	public void turnPageBackward() {
		setCurrentPage(getCurrentPage() - 1);
		refresh();
	}

	private void refresh() {
	}

	public void showBooks(Library library) {
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
