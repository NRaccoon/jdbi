package user;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());
        try (Handle handle = jdbi.open()) {

            UserDao dao = handle.attach(UserDao.class);
            dao.createTable();
            User user = User.builder()
                    .name("James Bond")
                    .username("007")
                    .id(444L)
                    .password("hello")
                    .email("bond.james@citromail.hu")
                    .gender(User.Gender.MALE)
                    .dob(LocalDate.parse("1920-11-11"))
                    .enabled(true)
                    .build();
            dao.insert(user);
            System.out.println(dao.findById(user.getId()) + " : id-val");
            System.out.println(dao.findByUsername(user.getUsername()) + ": username-mel");
            dao.list().stream().forEach(System.out::println);
            dao.delete(user);
        }
    }
}
