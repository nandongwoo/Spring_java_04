package ClientDTO;

public class ClientDTO {
    private Long id;
    private String accountNumber;
    private Long deposit = 0L;
    private Long withdraw = 0L;
    private String bankingAt;

    private static Long num = 0L;


    public ClientDTO() {
    }

    public ClientDTO(String accountNumber, Long deposit, Long withdraw, String bankingAt) {
        this.id = num++;
        this.accountNumber = accountNumber;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.bankingAt = bankingAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Long withdraw) {
        this.withdraw = withdraw;
    }

    public String getBankingAt() {
        return bankingAt;
    }

    public void setBankingAt(String bankingAt) {
        this.bankingAt = bankingAt;
    }

    public static Long getNum() {
        return num;
    }

    public static void setNum(Long num) {
        ClientDTO.num = num;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", bankingAt='" + bankingAt + '\'' +
                '}';
    }
}
