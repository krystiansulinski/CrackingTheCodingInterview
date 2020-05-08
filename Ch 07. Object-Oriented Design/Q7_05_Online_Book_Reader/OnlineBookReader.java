/*
 * 7.5 Online Book Reader
 * 
 * Design the data structures for an online book reader system.
 */

package Q7_05_Online_Book_Reader;

public class OnlineBookReader {
    private final Library library;
    private final Display display;
    private final UserManager userManager;

    public OnlineBookReader() {
        this.library = new Library();
        this.display = new Display();
        this.userManager = new UserManager();
    }

    public void welcomeScreen() {
        display.showBooks(library);
    }

    public void signUp() {
        userManager.addUser();
    }

    public void logIn(User id) {
        userManager.login(id);
    }

    public void logOut(User id) {
		userManager.logout(id);
	}
}
