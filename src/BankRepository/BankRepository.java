package BankRepository;

import AccountDTO.AccountDTO;
import ClientDTO.ClientDTO;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    List<AccountDTO> accountDTOList = new ArrayList<AccountDTO>();
    List<ClientDTO> clientDTOList = new ArrayList<ClientDTO>();

    public boolean creatIdentify(String account) {
        for (AccountDTO accountDTO1 : accountDTOList) {
            if (account.equals(accountDTO1.getAccountNumber())) {
                return false;
            }
        }
        return true;
    }


    public boolean identify(String account) {
        for (AccountDTO accountDTO1 : accountDTOList) {
            if (account.equals(accountDTO1.getAccountNumber())) {
                return true;
            }
        }
        return false;
    }

    public boolean passIdentify(String account, String pass) {
        for (AccountDTO accountDTO : accountDTOList) {
            if (accountDTO.getAccountNumber().equals(account) && accountDTO.getClientPass().equals(pass)) {
                return true;
            }
        }
        return false;
    }


    public AccountDTO creat(AccountDTO accountDTO) {
        accountDTOList.add(accountDTO);
        return accountDTO;
    }


    public Long search(String account) {
        for (AccountDTO accountDTO : accountDTOList) {
            if (account.equals(accountDTO.getAccountNumber())) {
                return accountDTO.getBalance();
            }
        }
        return null;
    }


    public boolean inBalance(String account, Long balance, String createdAt) {
        for (AccountDTO accountDTO : accountDTOList) {
            if (account.equals(accountDTO.getAccountNumber())) {
                accountDTO.setBalance(accountDTO.getBalance() + balance);
                ClientDTO clientDTO = new ClientDTO(account,balance,0L,createdAt);
                    clientDTO.setAccountNumber(account);
                    clientDTO.setDeposit(balance);
                    clientDTO.setBankingAt(createdAt);
                    clientDTOList.add(clientDTO);
                    return true;
            }
        }
        return false;
    }


    public boolean outBalance(String account, Long balance, String createdAt) {
        for (AccountDTO accountDTO : accountDTOList) {
            if (account.equals(accountDTO.getAccountNumber())) {
                if (accountDTO.getBalance() >= balance) {
                    accountDTO.setBalance(accountDTO.getBalance() - balance);
                    ClientDTO clientDTO = new ClientDTO(account,0L,balance,createdAt);
                    clientDTOList.add(clientDTO);
                    return true;
                }

            }
        }
        return false;
    }

    public List<ClientDTO> list() {
        return clientDTOList;
    }

}
