package org.example.ex10;

import org.example.ex10.beans.AccountRepository;
import org.example.ex10.model.Account;
import org.example.ex10.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class Ex6ApplicationTests {

    //@Mock
    @Autowired
    private AccountRepository accountRepository;

    //@InjectMocks
    @Autowired
    private TransferService transferService;

    @Test
    @DisplayName("It's test moneyTransfer")
    void moneyTransferTo() {

        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        when(accountRepository.findAccountById(1L)).thenReturn( sender );
        when(accountRepository.findAccountById(2L)).thenReturn( receiver );

        transferService.transferMoney(1, 2, new BigDecimal(100));

        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));
    }
}
