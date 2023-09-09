package com.example.restapi.service.impl;

import com.example.restapi.domain.*;
import com.example.restapi.repositories.UserRepository;
import com.example.restapi.service.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<User> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);
        List<User> actualFindAllResult = userServiceImpl.findAll();
        assertSame(userList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserServiceImpl#findAll()}
     */
    @Test
    void testFindAll2() {
        when(userRepository.findAll()).thenThrow(new BusinessException("An error occurred"));
        assertThrows(BusinessException.class, () -> userServiceImpl.findAll());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserServiceImpl#findById(Long)}
     */
    @Test
    void testFindById() {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(1L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(1L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(1L));
        card.setNumber("42");

        User user = new User();
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        User actualFindByIdResult = userServiceImpl.findById(1L);
        assertSame(user, actualFindByIdResult);
        assertEquals("1", actualFindByIdResult.getAccount().getBalance().toString());
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#findById(Long)}
     */


    /**
     * Method under test: {@link UserServiceImpl#findById(Long)}
     */
    @Test
    void testFindById3() {
        when(userRepository.findById(Mockito.<Long>any())).thenThrow(new BusinessException("An error occurred"));
        assertThrows(BusinessException.class, () -> userServiceImpl.findById(1L));
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#create(User)}
     */
    @Test
    void testCreate() {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(1L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(1L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(1L));
        card.setNumber("42");

        User userToCreate = new User();
        userToCreate.setAccount(account);
        userToCreate.setCard(card);
        userToCreate.setFeatures(new ArrayList<>());
        userToCreate.setId(1L);
        userToCreate.setName("Name");
        userToCreate.setNews(new ArrayList<>());
        assertThrows(BusinessException.class, () -> userServiceImpl.create(userToCreate));
    }

    /**
     * Method under test: {@link UserServiceImpl#create(User)}
     */
    @Test
    void testCreate2() {
        when(userRepository.existsByAccountNumber(Mockito.<String>any())).thenReturn(true);
        Account account = mock(Account.class);
        doNothing().when(account).setAgency(Mockito.<String>any());
        doNothing().when(account).setBalance(Mockito.<BigDecimal>any());
        doNothing().when(account).setId(Mockito.<Long>any());
        doNothing().when(account).setLimit(Mockito.<BigDecimal>any());
        doNothing().when(account).setNumber(Mockito.<String>any());
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(1L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(1L));
        account.setNumber("42");
        Card card = mock(Card.class);
        doNothing().when(card).setId(Mockito.<Long>any());
        doNothing().when(card).setLimit(Mockito.<BigDecimal>any());
        doNothing().when(card).setNumber(Mockito.<String>any());
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(1L));
        card.setNumber("42");
        User user = mock(User.class);
        doNothing().when(user).setAccount(Mockito.<Account>any());
        doNothing().when(user).setCard(Mockito.<Card>any());
        doNothing().when(user).setFeatures(Mockito.<List<Feature>>any());
        doNothing().when(user).setId(Mockito.<Long>any());
        doNothing().when(user).setName(Mockito.<String>any());
        doNothing().when(user).setNews(Mockito.<List<News>>any());
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());

        Account account2 = new Account();
        account2.setAgency("Agency");
        account2.setBalance(BigDecimal.valueOf(1L));
        account2.setId(1L);
        account2.setLimit(BigDecimal.valueOf(1L));
        account2.setNumber("42");

        Card card2 = new Card();
        card2.setId(1L);
        card2.setLimit(BigDecimal.valueOf(1L));
        card2.setNumber("42");

        Account account3 = new Account();
        account3.setAgency("Agency");
        account3.setBalance(BigDecimal.valueOf(1L));
        account3.setId(1L);
        account3.setLimit(BigDecimal.valueOf(1L));
        account3.setNumber("42");

        Card card3 = new Card();
        card3.setId(1L);
        card3.setLimit(BigDecimal.valueOf(1L));
        card3.setNumber("42");
        User userToCreate = mock(User.class);
        when(userToCreate.getId()).thenReturn(2L);
        when(userToCreate.getCard()).thenReturn(card3);
        when(userToCreate.getAccount()).thenReturn(account3);
        doNothing().when(userToCreate).setAccount(Mockito.<Account>any());
        doNothing().when(userToCreate).setCard(Mockito.<Card>any());
        doNothing().when(userToCreate).setFeatures(Mockito.<List<Feature>>any());
        doNothing().when(userToCreate).setId(Mockito.<Long>any());
        doNothing().when(userToCreate).setName(Mockito.<String>any());
        doNothing().when(userToCreate).setNews(Mockito.<List<News>>any());
        userToCreate.setAccount(account2);
        userToCreate.setCard(card2);
        userToCreate.setFeatures(new ArrayList<>());
        userToCreate.setId(1L);
        userToCreate.setName("Name");
        userToCreate.setNews(new ArrayList<>());
        assertThrows(BusinessException.class, () -> userServiceImpl.create(userToCreate));
        verify(userRepository).existsByAccountNumber(Mockito.<String>any());
        verify(user).setAccount(Mockito.<Account>any());
        verify(user).setCard(Mockito.<Card>any());
        verify(user).setFeatures(Mockito.<List<Feature>>any());
        verify(user).setId(Mockito.<Long>any());
        verify(user).setName(Mockito.<String>any());
        verify(user).setNews(Mockito.<List<News>>any());
        verify(account).setAgency(Mockito.<String>any());
        verify(account).setBalance(Mockito.<BigDecimal>any());
        verify(account).setId(Mockito.<Long>any());
        verify(account).setLimit(Mockito.<BigDecimal>any());
        verify(account).setNumber(Mockito.<String>any());
        verify(card).setId(Mockito.<Long>any());
        verify(card).setLimit(Mockito.<BigDecimal>any());
        verify(card).setNumber(Mockito.<String>any());
        verify(userToCreate, atLeast(1)).getAccount();
        verify(userToCreate).getCard();
        verify(userToCreate).getId();
        verify(userToCreate).setAccount(Mockito.<Account>any());
        verify(userToCreate).setCard(Mockito.<Card>any());
        verify(userToCreate).setFeatures(Mockito.<List<Feature>>any());
        verify(userToCreate).setId(Mockito.<Long>any());
        verify(userToCreate).setName(Mockito.<String>any());
        verify(userToCreate).setNews(Mockito.<List<News>>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(Long, User)}
     */
    @Test
    void testUpdate() {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(1L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(1L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(1L));
        card.setNumber("42");

        User userToUpdate = new User();
        userToUpdate.setAccount(account);
        userToUpdate.setCard(card);
        userToUpdate.setFeatures(new ArrayList<>());
        userToUpdate.setId(1L);
        userToUpdate.setName("Name");
        userToUpdate.setNews(new ArrayList<>());
        assertThrows(BusinessException.class, () -> userServiceImpl.update(1L, userToUpdate));
    }

    /**
     * Method under test: {@link UserServiceImpl#update(Long, User)}
     */
    @Test
    void testUpdate2() {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(1L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(1L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(1L));
        card.setNumber("42");

        User user = new User();
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);

        Account account2 = new Account();
        account2.setAgency("Agency");
        account2.setBalance(BigDecimal.valueOf(1L));
        account2.setId(1L);
        account2.setLimit(BigDecimal.valueOf(1L));
        account2.setNumber("42");

        Card card2 = new Card();
        card2.setId(1L);
        card2.setLimit(BigDecimal.valueOf(1L));
        card2.setNumber("42");

        User user2 = new User();
        user2.setAccount(account2);
        user2.setCard(card2);
        user2.setFeatures(new ArrayList<>());
        user2.setId(1L);
        user2.setName("Name");
        user2.setNews(new ArrayList<>());
        when(userRepository.save(Mockito.<User>any())).thenReturn(user2);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Account account3 = new Account();
        account3.setAgency("Agency");
        account3.setBalance(BigDecimal.valueOf(1L));
        account3.setId(1L);
        account3.setLimit(BigDecimal.valueOf(1L));
        account3.setNumber("42");

        Card card3 = new Card();
        card3.setId(1L);
        card3.setLimit(BigDecimal.valueOf(1L));
        card3.setNumber("42");

        User userToUpdate = new User();
        userToUpdate.setAccount(account3);
        userToUpdate.setCard(card3);
        userToUpdate.setFeatures(new ArrayList<>());
        userToUpdate.setId(1L);
        userToUpdate.setName("Name");
        userToUpdate.setNews(new ArrayList<>());
        User actualUpdateResult = userServiceImpl.update(2L, userToUpdate);
        assertSame(user2, actualUpdateResult);
        assertEquals("1", actualUpdateResult.getAccount().getBalance().toString());
        verify(userRepository).save(Mockito.<User>any());
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(Long, User)}
     */
    @Test
    void testUpdate3() {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(1L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(1L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(1L));
        card.setNumber("42");

        User user = new User();
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.save(Mockito.<User>any())).thenThrow(new BusinessException("An error occurred"));
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Account account2 = new Account();
        account2.setAgency("Agency");
        account2.setBalance(BigDecimal.valueOf(1L));
        account2.setId(1L);
        account2.setLimit(BigDecimal.valueOf(1L));
        account2.setNumber("42");

        Card card2 = new Card();
        card2.setId(1L);
        card2.setLimit(BigDecimal.valueOf(1L));
        card2.setNumber("42");

        User userToUpdate = new User();
        userToUpdate.setAccount(account2);
        userToUpdate.setCard(card2);
        userToUpdate.setFeatures(new ArrayList<>());
        userToUpdate.setId(1L);
        userToUpdate.setName("Name");
        userToUpdate.setNews(new ArrayList<>());
        assertThrows(BusinessException.class, () -> userServiceImpl.update(2L, userToUpdate));
        verify(userRepository).save(Mockito.<User>any());
        verify(userRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(Long, User)}
     */
    @Test
    void testUpdate4() {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(1L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(1L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(1L));
        card.setNumber("42");
        User user = mock(User.class);
        when(user.getId()).thenReturn(-1L);
        doNothing().when(user).setAccount(Mockito.<Account>any());
        doNothing().when(user).setCard(Mockito.<Card>any());
        doNothing().when(user).setFeatures(Mockito.<List<Feature>>any());
        doNothing().when(user).setId(Mockito.<Long>any());
        doNothing().when(user).setName(Mockito.<String>any());
        doNothing().when(user).setNews(Mockito.<List<News>>any());
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Account account2 = new Account();
        account2.setAgency("Agency");
        account2.setBalance(BigDecimal.valueOf(1L));
        account2.setId(1L);
        account2.setLimit(BigDecimal.valueOf(1L));
        account2.setNumber("42");

        Card card2 = new Card();
        card2.setId(1L);
        card2.setLimit(BigDecimal.valueOf(1L));
        card2.setNumber("42");

        User userToUpdate = new User();
        userToUpdate.setAccount(account2);
        userToUpdate.setCard(card2);
        userToUpdate.setFeatures(new ArrayList<>());
        userToUpdate.setId(1L);
        userToUpdate.setName("Name");
        userToUpdate.setNews(new ArrayList<>());
        assertThrows(BusinessException.class, () -> userServiceImpl.update(2L, userToUpdate));
        verify(userRepository).findById(Mockito.<Long>any());
        verify(user).getId();
        verify(user).setAccount(Mockito.<Account>any());
        verify(user).setCard(Mockito.<Card>any());
        verify(user).setFeatures(Mockito.<List<Feature>>any());
        verify(user).setId(Mockito.<Long>any());
        verify(user).setName(Mockito.<String>any());
        verify(user).setNews(Mockito.<List<News>>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#delete(Long)}
     */
    @Test
    void testDelete() {
        assertThrows(BusinessException.class, () -> userServiceImpl.delete(1L));
    }

    /**
     * Method under test: {@link UserServiceImpl#delete(Long)}
     */
    @Test
    void testDelete2() {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(1L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(1L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(1L));
        card.setNumber("42");

        User user = new User();
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        doNothing().when(userRepository).delete(Mockito.<User>any());
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        userServiceImpl.delete(2L);
        verify(userRepository).findById(Mockito.<Long>any());
        verify(userRepository).delete(Mockito.<User>any());
    }

    /**
     * Method under test: {@link UserServiceImpl#delete(Long)}
     */
    @Test
    void testDelete3() {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(1L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(1L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(1L));
        card.setNumber("42");

        User user = new User();
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        doThrow(new BusinessException("An error occurred")).when(userRepository).delete(Mockito.<User>any());
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(BusinessException.class, () -> userServiceImpl.delete(2L));
        verify(userRepository).findById(Mockito.<Long>any());
        verify(userRepository).delete(Mockito.<User>any());
    }

}

