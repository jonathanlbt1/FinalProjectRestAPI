package com.example.restapi.controller;

import com.example.restapi.domain.Account;
import com.example.restapi.domain.Card;
import com.example.restapi.domain.User;
import com.example.restapi.dto.AccountDto;
import com.example.restapi.dto.CardDto;
import com.example.restapi.dto.FeatureDto;
import com.example.restapi.dto.UserDto;
import com.example.restapi.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#create(UserDto)}
     */
    @Test
    void testCreate() throws Exception {
        when(userService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        BigDecimal balance = BigDecimal.valueOf(1L);
        AccountDto account = new AccountDto(1L, "42", "Agency", balance, BigDecimal.valueOf(1L));

        CardDto card = new CardDto(1L, "42", BigDecimal.valueOf(1L));

        ArrayList<FeatureDto> features = new ArrayList<>();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new UserDto(1L, "Name", account, card, features, new ArrayList<>())));
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#create(UserDto)}
     */
    @Test
    void testCreate2() throws Exception {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(4L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(4L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(4L));
        card.setNumber("42");

        User user = new User();
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userService.findAll()).thenReturn(userList);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        BigDecimal balance = BigDecimal.valueOf(1L);
        AccountDto account2 = new AccountDto(1L, "42", "Agency", balance, BigDecimal.valueOf(1L));

        CardDto card2 = new CardDto(1L, "42", BigDecimal.valueOf(1L));

        ArrayList<FeatureDto> features = new ArrayList<>();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(
                objectMapper.writeValueAsString(new UserDto(1L, "Name", account2, card2, features, new ArrayList<>())));
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"name\":\"Name\",\"account\":{\"id\":1,\"number\":\"42\",\"agency\":\"Agency\",\"balance\":4,\"limit\":4},\"card"
                                        + "\":{\"id\":1,\"number\":\"42\",\"limit\":4},\"features\":[],\"news\":[]}]"));
    }

    /**
     * Method under test: {@link UserController#create(UserDto)}
     */
    @Test
    void testCreate3() throws Exception {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(4L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(4L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(4L));
        card.setNumber("42");

        User user = new User();
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());

        Account account2 = new Account();
        account2.setAgency("42");
        account2.setBalance(BigDecimal.valueOf(4L));
        account2.setId(2L);
        account2.setLimit(BigDecimal.valueOf(4L));
        account2.setNumber("Number");

        Card card2 = new Card();
        card2.setId(2L);
        card2.setLimit(BigDecimal.valueOf(4L));
        card2.setNumber("Number");

        User user2 = new User();
        user2.setAccount(account2);
        user2.setCard(card2);
        user2.setFeatures(new ArrayList<>());
        user2.setId(2L);
        user2.setName("42");
        user2.setNews(new ArrayList<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user2);
        userList.add(user);
        when(userService.findAll()).thenReturn(userList);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        BigDecimal balance = BigDecimal.valueOf(1L);
        AccountDto account3 = new AccountDto(1L, "42", "Agency", balance, BigDecimal.valueOf(1L));

        CardDto card3 = new CardDto(1L, "42", BigDecimal.valueOf(1L));

        ArrayList<FeatureDto> features = new ArrayList<>();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(
                objectMapper.writeValueAsString(new UserDto(1L, "Name", account3, card3, features, new ArrayList<>())));
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":2,\"name\":\"42\",\"account\":{\"id\":2,\"number\":\"Number\",\"agency\":\"42\",\"balance\":4,\"limit\":4},\"card\""
                                        + ":{\"id\":2,\"number\":\"Number\",\"limit\":4},\"features\":[],\"news\":[]},{\"id\":1,\"name\":\"Name\",\"account\":{\"id\""
                                        + ":1,\"number\":\"42\",\"agency\":\"Agency\",\"balance\":4,\"limit\":4},\"card\":{\"id\":1,\"number\":\"42\",\"limit\":4},"
                                        + "\"features\":[],\"news\":[]}]"));
    }

    /**
     * Method under test: {@link UserController#delete(Long)}
     */
    @Test
    void testDelete() throws Exception {
        doNothing().when(userService).delete(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link UserController#delete(Long)}
     */
    @Test
    void testDelete2() throws Exception {
        doNothing().when(userService).delete(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link UserController#findAll()}
     */
    @Test
    void testFindAll() throws Exception {
        when(userService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#findAll()}
     */
    @Test
    void testFindAll2() throws Exception {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(4L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(4L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(4L));
        card.setNumber("42");

        User user = new User();
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userService.findAll()).thenReturn(userList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"name\":\"Name\",\"account\":{\"id\":1,\"number\":\"42\",\"agency\":\"Agency\",\"balance\":4,\"limit\":4},\"card"
                                        + "\":{\"id\":1,\"number\":\"42\",\"limit\":4},\"features\":[],\"news\":[]}]"));
    }

    /**
     * Method under test: {@link UserController#findAll()}
     */
    @Test
    void testFindAll3() throws Exception {
        Account account = new Account();
        account.setAgency("Agency");
        account.setBalance(BigDecimal.valueOf(4L));
        account.setId(1L);
        account.setLimit(BigDecimal.valueOf(4L));
        account.setNumber("42");

        Card card = new Card();
        card.setId(1L);
        card.setLimit(BigDecimal.valueOf(4L));
        card.setNumber("42");

        User user = new User();
        user.setAccount(account);
        user.setCard(card);
        user.setFeatures(new ArrayList<>());
        user.setId(1L);
        user.setName("Name");
        user.setNews(new ArrayList<>());

        Account account2 = new Account();
        account2.setAgency("42");
        account2.setBalance(BigDecimal.valueOf(4L));
        account2.setId(2L);
        account2.setLimit(BigDecimal.valueOf(4L));
        account2.setNumber("Number");

        Card card2 = new Card();
        card2.setId(2L);
        card2.setLimit(BigDecimal.valueOf(4L));
        card2.setNumber("Number");

        User user2 = new User();
        user2.setAccount(account2);
        user2.setCard(card2);
        user2.setFeatures(new ArrayList<>());
        user2.setId(2L);
        user2.setName("42");
        user2.setNews(new ArrayList<>());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user2);
        userList.add(user);
        when(userService.findAll()).thenReturn(userList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":2,\"name\":\"42\",\"account\":{\"id\":2,\"number\":\"Number\",\"agency\":\"42\",\"balance\":4,\"limit\":4},\"card\""
                                        + ":{\"id\":2,\"number\":\"Number\",\"limit\":4},\"features\":[],\"news\":[]},{\"id\":1,\"name\":\"Name\",\"account\":{\"id\""
                                        + ":1,\"number\":\"42\",\"agency\":\"Agency\",\"balance\":4,\"limit\":4},\"card\":{\"id\":1,\"number\":\"42\",\"limit\":4},"
                                        + "\"features\":[],\"news\":[]}]"));
    }

    /**
     * Method under test: {@link UserController#findById(Long)}
     */
    @Test
    void testFindById() throws Exception {
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
        when(userService.findById(Mockito.<Long>any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{id}", 1L);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"account\":{\"id\":1,\"number\":\"42\",\"agency\":\"Agency\",\"balance\":1,\"limit\":1},\"card"
                                        + "\":{\"id\":1,\"number\":\"42\",\"limit\":1},\"features\":[],\"news\":[]}"));
    }

    /**
     * Method under test: {@link UserController#update(Long, UserDto)}
     */
    @Test
    void testUpdate() throws Exception {
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
        when(userService.update(Mockito.<Long>any(), Mockito.<User>any())).thenReturn(user);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/users/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        BigDecimal balance = BigDecimal.valueOf(1L);
        AccountDto account2 = new AccountDto(1L, "42", "Agency", balance, BigDecimal.valueOf(1L));

        CardDto card2 = new CardDto(1L, "42", BigDecimal.valueOf(1L));

        ArrayList<FeatureDto> features = new ArrayList<>();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(
                objectMapper.writeValueAsString(new UserDto(1L, "Name", account2, card2, features, new ArrayList<>())));
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"account\":{\"id\":1,\"number\":\"42\",\"agency\":\"Agency\",\"balance\":1,\"limit\":1},\"card"
                                        + "\":{\"id\":1,\"number\":\"42\",\"limit\":1},\"features\":[],\"news\":[]}"));
    }
}

