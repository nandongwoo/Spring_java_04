package BankService;

import AccountDTO.AccountDTO;
import BankRepository.BankRepository;
import ClientDTO.ClientDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class BankService {
    Scanner scanner = new Scanner(System.in);
    BankRepository bankRepository = new BankRepository();

    public void creat() {
        LocalDateTime now = LocalDateTime.now();
        System.out.print("계좌번호 : ");
        String account = scanner.next();
        boolean result = bankRepository.creatIdentify(account);
        if (result) {
            System.out.println("사용할 수있는 계좌번호입니다.");
            System.out.print("계좌주 : ");
            String name = scanner.next();
            System.out.print("비밀번호 : ");
            String pass = scanner.next();
            String createdAt = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
            AccountDTO accountDTO = new AccountDTO(name, account, pass, createdAt);
            accountDTO = bankRepository.creat(accountDTO);
            System.out.println("계좌생성이 완료되었습니다 : " + accountDTO);
        } else {
            System.out.println("이미 등록 된 계좌입니다");
        }
    }

    public void search() {
        System.out.print("계좌번호 : ");
        String account = scanner.next();
        boolean result = bankRepository.identify(account);
        if (result) {
            Long balance = bankRepository.search(account);
            System.out.println(balance + "원");
        } else {
            System.out.println("없는 계좌번호입니다.");
        }
    }

    public void inBalance() {
        LocalDateTime now = LocalDateTime.now();
        System.out.print("계좌번호 : ");
        String account = scanner.next();
        boolean result = bankRepository.identify(account);
        if (result) {
            System.out.print("입금 금액 : ");
            Long balance = scanner.nextLong();
            String createdAt = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
            boolean result2 = bankRepository.inBalance(account, balance, createdAt);
            if (result2) {
                System.out.println(balance + "원 입금되었습니다");
            } else {
                System.out.println("입금실패");
            }


        } else {
            System.out.println("없는 계좌번호입니다.");
        }
    }

    public void outBalance() {
        LocalDateTime now = LocalDateTime.now();
        System.out.print("계좌번호 : ");
        String account = scanner.next();
        boolean result = bankRepository.identify(account);
        if (result) {
            System.out.print("비밀번호 : ");
            String pass = scanner.next();
            boolean result2 = bankRepository.passIdentify(account, pass);
            if (result2) {
                System.out.print("출금 금액 : ");
                Long balance = scanner.nextLong();
                String createdAt = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
                boolean result3 = bankRepository.outBalance(account, balance, createdAt);
                if (result3) {
                    System.out.println(balance + "원 출금완료되었습니다.");
                } else {
                    System.out.println("잔액이 부족합니다.");
                }

            } else {
                System.out.println("비밀번호를 확인하세요.");
            }
        } else {
            System.out.println("계좌번호를 확인하세요.");
        }

    }

    public void list() {
        for (ClientDTO clientDTO : bankRepository.list()) {
            System.out.println(clientDTO.toString());
        }
    }

    public void input() {
        for (ClientDTO clientDTO : bankRepository.list()) {
            if (clientDTO.getWithdraw() == 0) {
                System.out.println(clientDTO.toString());
            }
        }
    }

    public void output() {
        for (ClientDTO clientDTO : bankRepository.list()) {
            if (clientDTO.getDeposit() == 0) {
                System.out.println(clientDTO.toString());
            }
        }
    }

}
