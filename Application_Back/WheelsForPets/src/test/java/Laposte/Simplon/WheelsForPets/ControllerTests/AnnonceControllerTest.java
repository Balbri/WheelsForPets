package Laposte.Simplon.WheelsForPets.ControllerTests;


import Laposte.Simplon.WheelsForPets.Controller.*;
import Laposte.Simplon.WheelsForPets.Model.Annonce;
import Laposte.Simplon.WheelsForPets.Model.Message;
import Laposte.Simplon.WheelsForPets.Model.User;
import Laposte.Simplon.WheelsForPets.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AnnonceControllerTest {

    @Autowired
    MockMvc mockMVC;

    @MockBean
    AnimalController animalController;
    @MockBean
    UserController userController;
    @MockBean
    AnnonceController annonceController;
    @MockBean
    MessageController messageController;
    @MockBean
    ArticleController articleController;
    @Mock
    AnnonceRepository annonceRepository;




    @Test
    public void getAnnonces() throws Exception{
        when(this.annonceRepository.findAll()).thenReturn(new ArrayList<Annonce>());

        this.mockMVC.perform(get("/api/annonces")).andExpect(status().isOk());
    }


    @Test
    public void getLast3() throws Exception{
        when(this.annonceRepository.getLast3Annonces()).thenReturn(new ArrayList<>());
        this.mockMVC.perform(get("/api/annonces")).andExpect(status().isOk());
    }

    @Test public void getById() throws Exception{

        when(this.annonceRepository.findById(10)).thenReturn(Optional.of(new Annonce(10, new Date("2018-12-12"), "titre test", "description test", "houilles", 78800, new Date("2019-12-12"), "Paris", 75000, new Date("2019-13-12"), 25, true)));

        this.mockMVC.perform(get("/api/annonces/10")).andExpect(status().isOk())
                .andExpect(jsonPath("annonceid").value("10"))
                .andExpect(jsonPath("dateredaction").value("2018-12-12")) ;

    }
}
