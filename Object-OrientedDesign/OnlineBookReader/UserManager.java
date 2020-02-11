package OnlineBookReader;

import java.util.List;

public class UserManager {
	private List<User> users;

	public void addUser() {
		users.add(new User(users.size()));
	}

	public void removeUser(User user) {
		users.remove(user);
	}

	public void login(User id) {
	}

	public void logout(User id) {
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
