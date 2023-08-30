package Ex;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex {
    public static void main(String[] args) {
        // static으로 메서드를 만들면 클래스메서드라고 한다. (객체로 접근하지않고 클래스 이름, 메서드 이름으로 접근)
        LocalDateTime now = LocalDateTime.now();
        String createdAt = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));

    }
}